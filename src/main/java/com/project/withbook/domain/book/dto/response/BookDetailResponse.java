package com.project.withbook.domain.book.dto.response;

import com.project.withbook.domain.book.model.BookInfo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class BookDetailResponse {

    private final String title;

    private final String author;

    private final String description;

    private final String coverImgUrl;

    private final int totalPage;

    private final String publisher;

    private final LocalDate pubDate;

    private final String isbn;

    // private final String fullDescription;
    // private final String story;

    public static BookDetailResponse from(BookInfo data) {
        return BookDetailResponse.builder()
                .title(data.title())
                .author(data.author())
                .description(data.description())
                .coverImgUrl(data.coverImgUrl())
                .totalPage(data.totalPage())
                .publisher(data.publisher())
                .pubDate(data.pubDate())
                .isbn(data.isbn())
                .build();
    }
}
