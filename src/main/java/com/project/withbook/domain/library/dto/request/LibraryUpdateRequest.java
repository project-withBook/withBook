package com.project.withbook.domain.library.dto.request;

import com.project.withbook.domain.library.enums.ReadingStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LibraryUpdateRequest {

    private final Long libraryId;

    private final ReadingStatus status;

    private final Integer nowPage;
}
