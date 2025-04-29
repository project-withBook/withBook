package com.project.withbook.domain.readingrecord.repository;

import com.project.withbook.domain.readingrecord.entity.ReadingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRecordRepository extends JpaRepository<ReadingRecord,Long> {
}
