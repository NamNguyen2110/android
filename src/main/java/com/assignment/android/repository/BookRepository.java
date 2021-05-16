package com.assignment.android.repository;

import com.assignment.android.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.status = '1'")
    List<Book> getHomePageBook();

    @Query("SELECT b FROM Book b WHERE b.status = '2'")
    List<Book> getTrendingBook();

}
