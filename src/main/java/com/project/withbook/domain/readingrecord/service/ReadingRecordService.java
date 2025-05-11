package com.project.withbook.domain.readingrecord.service;

import com.project.withbook.domain.readingrecord.dto.request.CreateReadingRecordRequestDto;

public interface ReadingRecordService {
    void createReadingRecord(CreateReadingRecordRequestDto request, Long userId);
}
