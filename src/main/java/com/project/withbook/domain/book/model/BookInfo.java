package com.project.withbook.domain.book.model;

import java.time.LocalDate;

public record BookInfo(

        String title,

        String author,

        String description,

        String coverImgUrl,

        int customerReviewRank,

        int totalPage,

        String publisher,

        LocalDate pubDate,

        String isbn

) {
}
