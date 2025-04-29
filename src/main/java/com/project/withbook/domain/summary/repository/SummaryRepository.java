package com.project.withbook.domain.summary.repository;

import com.project.withbook.domain.summary.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary,Long> {
}
