package com.project.withbook.domain.book.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.w3c.dom.Element;

import static com.project.withbook.domain.book.util.XmlUtils.getTagValue;
import static com.project.withbook.domain.book.util.XmlUtils.parseIntOrZero;

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

    public static BookSearchItemResponse from(Element element) {
        return BookSearchItemResponse.builder()
                .title(getTagValue("title", element))
                .author(getTagValue("author", element))
                .description(getTagValue("description", element))
                .coverImgUrl(getTagValue("cover", element))
                .customerReviewRank(parseIntOrZero(getTagValue("customerReviewRank", element)))
                .publisher(getTagValue("publisher", element))
                .isbn(getTagValue("isbn13", element))
                .build();
    }
}
