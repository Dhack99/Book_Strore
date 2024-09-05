package com.BookStore.Book.Store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "MyBooks")
public class MyBookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
