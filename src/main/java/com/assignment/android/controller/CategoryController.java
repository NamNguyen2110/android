package com.assignment.android.controller;

import com.assignment.android.model.Category;
import com.assignment.android.repository.CategoryRepository;
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
public class CategoryController {
    private final CategoryRepository categoryRepo;

    @GetMapping("/category/list")
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @GetMapping("/category/book")
    public Optional<Category> getBookFromCategory(@RequestParam("id") Integer id) {
        return categoryRepo.findById(id);
    }

}
