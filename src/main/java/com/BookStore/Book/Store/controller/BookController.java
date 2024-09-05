package com.BookStore.Book.Store.controller;


import com.BookStore.Book.Store.entity.Book;
import com.BookStore.Book.Store.entity.MyBookList;
import com.BookStore.Book.Store.service.BookService;
import com.BookStore.Book.Store.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
     public ModelAndView getAllBook(){
        List<Book> list=bookService.getAllBook();
        return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        try{
            bookService.save(book);

        }catch (Exception e){
            e.getMessage();
        }
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList>list = myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id){
       Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
       myBookListService.saveMyBook(myBookList);

        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteByID(id);
        return "redirect:/available_books";
    }

}
