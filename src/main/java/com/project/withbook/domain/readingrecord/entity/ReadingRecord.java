package com.project.withbook.domain.readingrecord.entity;

import com.project.withbook.common.base.BaseEntity;
import com.project.withbook.domain.book.entity.Book;
import com.project.withbook.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reading_records")
public class ReadingRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 1, nullable = false)
    private int rating;

    @Column(name = "like_count", length = 10, nullable = false)
    private int likeCount;

    @Builder
    public ReadingRecord(User user, Book book, String title, String content, int rating, int likeCount) {
        this.user = user;
        this.book = book;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.likeCount = likeCount;
    }
}
