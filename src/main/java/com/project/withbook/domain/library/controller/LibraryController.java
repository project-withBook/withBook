package com.project.withbook.domain.library.controller;

import com.project.withbook.domain.library.dto.request.LibraryCreateRequest;
import com.project.withbook.domain.library.dto.request.LibraryUpdateRequest;
import com.project.withbook.domain.library.dto.response.LibraryResponse;
import com.project.withbook.domain.library.enums.ReadingStatus;
import com.project.withbook.domain.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<LibraryResponse> createLibrary(@RequestBody LibraryCreateRequest libraryCreateRequest) {
        // TODO: Redis 캐시로 책 정보 조회 후 Book 저장
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.createLibrary(userId, libraryCreateRequest));
    }

    @GetMapping
    public ResponseEntity<Map<ReadingStatus, List<LibraryResponse>>> getLibraries() {
        // 추후 변경
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.getLibraries(userId));
    }

    @PutMapping
    public ResponseEntity<LibraryResponse> updateLibrary(@RequestBody LibraryUpdateRequest libraryUpdateRequest) {
        // 나중에 변경
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.updateLibrary(userId, libraryUpdateRequest));
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long libraryId) {
        // 나중에 변경
        Long userId = 1L;
        libraryService.deleteLibrary(userId, libraryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
