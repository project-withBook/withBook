package com.project.withbook.domain.book.controller;

import com.project.withbook.domain.book.dto.response.BookDetailResponse;
import com.project.withbook.domain.book.dto.response.BookSearchItemResponse;
import com.project.withbook.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookSearchItemResponse>> searchBooks(@RequestParam String query,
                                                                    @RequestParam String queryType) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchBooks(query, queryType));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetailResponse> getBook(@PathVariable String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(isbn));
    }
    
}
