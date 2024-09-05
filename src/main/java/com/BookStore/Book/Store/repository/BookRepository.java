package com.BookStore.Book.Store.repository;

import com.BookStore.Book.Store.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
