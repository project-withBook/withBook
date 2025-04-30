package com.project.withbook.domain.category.repository;

import com.project.withbook.domain.category.entity.UserFavoriteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFavoriteCategoryRepository extends JpaRepository<UserFavoriteCategory,Long> {
}
