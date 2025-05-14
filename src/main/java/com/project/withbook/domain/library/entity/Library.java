package com.project.withbook.domain.library.entity;

import com.project.withbook.common.base.BaseEntity;
import com.project.withbook.domain.book.entity.Book;
import com.project.withbook.domain.library.enums.ReadingStatus;
import com.project.withbook.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
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

    @Builder
    public Library(User user, Book book, ReadingStatus status, int nowPage) {
        this.user = user;
        this.book = book;
        this.status = status;
        this.nowPage = nowPage;
    }

    public void updateLibrary(ReadingStatus status, Integer nowPage) {
        if (status != null) this.status = status;
        if (nowPage != null) this.nowPage = nowPage;
    }

    public boolean isOwnedBy(Long userId) {
        return this.user.getId().equals(userId);
    }
}
