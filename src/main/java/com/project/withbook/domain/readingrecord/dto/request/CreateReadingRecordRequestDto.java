package com.project.withbook.domain.readingrecord.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateReadingRecordRequestDto {
    private final Long bookId;
    private final String title;
    private final String content;
    private final int rating;
}
