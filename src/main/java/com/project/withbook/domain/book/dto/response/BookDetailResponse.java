package com.project.withbook.domain.book.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.w3c.dom.Element;

import java.time.LocalDate;

import static com.project.withbook.domain.book.util.XmlUtils.getTagValue;
import static com.project.withbook.domain.book.util.XmlUtils.parseIntOrZero;

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

    public static BookDetailResponse from(Element element) {
        return BookDetailResponse.builder()
                .title(getTagValue("title", element))
                .author(getTagValue("author", element))
                .description(getTagValue("description", element))
                .coverImgUrl(getTagValue("cover", element))
                .totalPage(parseIntOrZero(getTagValue("itemPage", element)))
                .publisher(getTagValue("publisher", element))
                .pubDate(LocalDate.parse(getTagValue("pubDate", element)))
                .isbn(getTagValue("isbn13", element))
                .build();
    }
}
