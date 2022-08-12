package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;
@Component
public class DummyBookFilter {
    private final BookService bookService;

    public DummyBookFilter(BookService bookService){
        this.bookService = bookService;
    }

    @PostConstruct
    public void init(){
        bookService.addBook(new Book(null,"El señor de los anillos","Libro completo de la trilogia","Jose", 5, 1));
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
        bookService.addBook(new Book(null,"El Hobbit","Libro completo de la trilogia","J:R:R Tolkien", 5, 1));
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
        bookService.addBook(new Book(null,"Harry Potter y la camara secreta","Libro completo de la trilogia","J:R:R Tolkien", 5, 1));
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
        bookService.addBook(new Book(null,"Harry Potter","Libro completo de la trilogia","J:R:R Tolkien", 5, 1));

    }
}
