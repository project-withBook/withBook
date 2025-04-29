package com.project.withbook.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.withbook.domain.user.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
