package com.project.withbook.domain.book.entity;

import com.project.withbook.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "books")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 100, nullable = false)
    private String publisher;

    @Column(length = 100, nullable = false)
    private String isbn;

    @Column(name = "total_page", nullable = false)
    private int totalPage;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "cover_img_url", nullable = false)
    private String coverImgUrl;
}
