package com.project.withbook.domain.summary.entity;

import com.project.withbook.common.base.BaseEntity;
import com.project.withbook.domain.readingrecord.entity.ReadingRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "summary")
public class Summary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private ReadingRecord readingRecord;

    @Column(name = "summary_text", columnDefinition = "TEXT", nullable = false)
    private String summaryText;
}
