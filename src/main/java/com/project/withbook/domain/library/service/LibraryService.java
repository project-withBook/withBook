package com.project.withbook.domain.library.service;

import com.project.withbook.domain.library.dto.request.LibraryCreateRequest;
import com.project.withbook.domain.library.dto.request.LibraryUpdateRequest;
import com.project.withbook.domain.library.dto.response.LibraryResponse;
import com.project.withbook.domain.library.entity.Library;
import com.project.withbook.domain.library.enums.ReadingStatus;
import com.project.withbook.domain.library.repository.LibraryRepository;
import com.project.withbook.domain.user.entity.User;
import com.project.withbook.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final UserRepository userRepository;

    public LibraryResponse createLibrary(Long userId, LibraryCreateRequest libraryCreateRequest) {
        // TODO: Redis 캐시로 책 정보 조회 후 Book 저장
        return null;
    }

    @Transactional(readOnly = true)
    public Map<ReadingStatus, List<LibraryResponse>> getLibraries(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다. (변경 예정)"));

        List<Library> libraries = libraryRepository.findAllByUserOrderByUpdatedAtDesc(user);

        return libraries.stream()
                .map(LibraryResponse::from)
                .collect(Collectors.groupingBy(
                        LibraryResponse::getStatus,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    @Transactional
    public LibraryResponse updateLibrary(Long userId, LibraryUpdateRequest libraryUpdateRequest) {
        Library library  = libraryRepository.findById(libraryUpdateRequest.getLibraryId())
                .orElseThrow(() -> new RuntimeException("서재 등록 정보를 찾을 수 없습니다. (변경 예정)"));

        if (!library.isOwnedBy(userId)) {
            throw new RuntimeException("해당 서재에 대한 권한이 없습니다.");
        }

        library.updateLibrary(libraryUpdateRequest.getStatus(), libraryUpdateRequest.getNowPage());

        return LibraryResponse.from(library);
    }

    @Transactional
    public void deleteLibrary(Long userId, Long libraryId) {
        Library library  = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("서재 등록 정보를 찾을 수 없습니다. (변경 예정)"));

        if (!library.isOwnedBy(userId)) {
            throw new RuntimeException("해당 서재에 대한 권한이 없습니다.");
        }

        libraryRepository.delete(library);
    }
}
