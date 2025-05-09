package com.project.withbook.domain.book.dto.response;

import com.project.withbook.domain.book.model.BookInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookSearchItemResponse {

    private final String title;

    private final String author;

    private final String description;

    private final String coverImgUrl;

    private final int customerReviewRank;

    private final String publisher;

    private final String isbn;

    public static BookSearchItemResponse from(BookInfo data) {
        return BookSearchItemResponse.builder()
                .title(data.title())
                .author(data.author())
                .description(data.description())
                .coverImgUrl(data.coverImgUrl())
                .customerReviewRank(data.customerReviewRank())
                .publisher(data.publisher())
                .isbn(data.isbn())
                .build();
    }
}
