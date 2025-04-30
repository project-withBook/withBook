package com.project.withbook.domain.book.controller;

import com.project.withbook.domain.book.dto.response.BookInfoResponse;
import com.project.withbook.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookInfoResponse>> searchBooks(@RequestParam(required = false) String keyword,
                                                              @RequestParam(required = false) String title,
                                                              @RequestParam(required = false) String author,
                                                              @RequestParam(required = false) String publisher) {
        return ResponseEntity.ok().body(bookService.searchBooks(keyword, title, author, publisher));
    }
    
}
