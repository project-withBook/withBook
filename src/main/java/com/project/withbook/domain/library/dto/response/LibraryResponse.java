package com.project.withbook.domain.library.dto.response;

import com.project.withbook.domain.library.entity.Library;
import com.project.withbook.domain.library.enums.ReadingStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LibraryResponse {

    private final Long id;

    private final String title;

    private final String author;

    private final String description;

    private final String coverImgUrl;

    private final int totalPage;

    private final int nowPage;

    private final ReadingStatus status;

    private final String statusLabel;

    public static LibraryResponse from(Library library) {
        return LibraryResponse.builder()
                .id(library.getId())
                .title(library.getBook().getTitle())
                .author(library.getBook().getAuthor())
                .description(library.getBook().getDescription())
                .coverImgUrl(library.getBook().getCoverImgUrl())
                .totalPage(library.getBook().getTotalPage())
                .nowPage(library.getNowPage())
                .status(library.getStatus())
                .statusLabel(library.getStatus().getLabel())
                .build();
    }

}
