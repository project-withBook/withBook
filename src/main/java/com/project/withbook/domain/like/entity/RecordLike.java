package com.project.withbook.domain.like.entity;

import com.project.withbook.domain.readingrecord.entity.ReadingRecord;
import com.project.withbook.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reading_record_like")
public class RecordLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private ReadingRecord readingRecord;
}
