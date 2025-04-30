package com.project.withbook.domain.book.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookInfoResponse {

    private final String title;

    private final String author;

    private final String description;

    private final String publisher;

    private final String isbn;

    private final String coverImgUrl;

    private final int customerReviewRank;

    public static BookInfoResponse of(String title, String author, String description,
                                      String publisher, String isbn, String coverImgUrl,
                                      int customerReviewRank) {
        return BookInfoResponse.builder()
                .title(title)
                .author(author)
                .description(description)
                .publisher(publisher)
                .isbn(isbn)
                .author(author)
                .coverImgUrl(coverImgUrl)
                .customerReviewRank(customerReviewRank)
                .build();
    }
}
