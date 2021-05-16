package com.assignment.android.controller;

import com.assignment.android.model.Book;
import com.assignment.android.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepo;

    @GetMapping("/book/list")
    private List<Book> getHomePageBook() {
        return bookRepo.getHomePageBook();
    }

    @GetMapping("/book/trending")
    private List<Book> getTrendingBook() {
        return bookRepo.getTrendingBook();
    }

    @GetMapping("/book")
    private Optional<Book> getBook(@RequestParam("id") Integer id) {
        return bookRepo.findById(id);
    }
}
