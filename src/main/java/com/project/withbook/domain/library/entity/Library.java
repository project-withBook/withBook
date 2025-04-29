package com.project.withbook.domain.library.entity;

import com.project.withbook.common.base.BaseEntity;
import com.project.withbook.domain.book.entity.Book;
import com.project.withbook.domain.library.enums.ReadingStatus;
import com.project.withbook.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Library extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingStatus status;

    @Column(name = "now_page", nullable = false)
    private int nowPage;
}
