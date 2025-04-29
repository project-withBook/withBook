package com.project.withbook.domain.category.repository;

import com.project.withbook.domain.category.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
