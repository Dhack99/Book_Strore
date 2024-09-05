package com.BookStore.Book.Store.service;

import com.BookStore.Book.Store.entity.Book;
import com.BookStore.Book.Store.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void save(Book book){
        bookRepository.save(book);
        System.out.println("Book saved: " + book.toString());
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void deleteByID(int id){
         bookRepository.deleteById(id);
    }
}
