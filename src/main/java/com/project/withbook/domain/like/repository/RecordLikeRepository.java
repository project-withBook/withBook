package com.project.withbook.domain.like.repository;

import com.project.withbook.domain.like.entity.RecordLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordLikeRepository extends JpaRepository<RecordLike,Long> {
}
