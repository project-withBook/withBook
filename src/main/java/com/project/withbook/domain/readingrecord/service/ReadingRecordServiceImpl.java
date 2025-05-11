package com.project.withbook.domain.readingrecord.service;

import com.project.withbook.domain.book.entity.Book;
import com.project.withbook.domain.book.repository.BookRepository;
import com.project.withbook.domain.readingrecord.dto.request.CreateReadingRecordRequestDto;
import com.project.withbook.domain.readingrecord.entity.ReadingRecord;
import com.project.withbook.domain.readingrecord.repository.ReadingRecordRepository;
import com.project.withbook.domain.user.entity.User;
import com.project.withbook.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadingRecordServiceImpl implements ReadingRecordService {

    private final ReadingRecordRepository readingRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public void createReadingRecord(CreateReadingRecordRequestDto request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("도서를 찾을 수 없습니다."));

        ReadingRecord record = ReadingRecord.builder()
                .user(user)
                .book(book)
                .title(request.getTitle())
                .content(request.getContent())
                .rating(request.getRating())
                .likeCount(0)
                .build();

        readingRecordRepository.save(record);
    }
}
