package com.BookStore.Book.Store.service;

import com.BookStore.Book.Store.entity.MyBookList;
import com.BookStore.Book.Store.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBook(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }
    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
