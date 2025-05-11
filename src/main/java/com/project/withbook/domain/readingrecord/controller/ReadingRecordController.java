package com.project.withbook.domain.readingrecord.controller;

import com.project.withbook.domain.readingrecord.dto.request.CreateReadingRecordRequestDto;
import com.project.withbook.domain.readingrecord.dto.response.CreateReadingRecordResponseDto;
import com.project.withbook.domain.readingrecord.service.ReadingRecordService;
import com.project.withbook.global.jwt.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reading-records")
@RequiredArgsConstructor
public class ReadingRecordController {

    private final ReadingRecordService readingRecordService;

    @PostMapping
    public ResponseEntity<CreateReadingRecordResponseDto> createReadingRecord(
            @RequestBody CreateReadingRecordRequestDto request,
            @LoginUser Long userId
    ) {
        readingRecordService.createReadingRecord(request, userId);
        return ResponseEntity.ok(new CreateReadingRecordResponseDto("독서 기록이 성공적으로 작성되었습니다."));
    }
}
