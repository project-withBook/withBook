package com.project.withbook.domain.library.repository;

import com.project.withbook.domain.library.entity.Library;
import com.project.withbook.domain.user.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    @EntityGraph(attributePaths = {"user", "book"})
    List<Library> findAllByUserOrderByUpdatedAtDesc(User user);
}
