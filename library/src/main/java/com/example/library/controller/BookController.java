package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping({"book"})
public class BookController {
    private final BookService bookservice;

    public BookController(BookService bookservice){
        this.bookservice = bookservice;
    }

    /*@GetMapping("")
    public String home(){
        return "Holaaaaaaaaaa";
    }*/

    @GetMapping("")
    public List<Book> getAll(@RequestParam(required = false) String authorId, @RequestParam(required = false) String title){
    
        if(authorId != null){
            return this.bookservice.findByAuthor(authorId);
        }else if(title != null){
            return this.bookservice.findByTitle(title);
        }else{
            return bookservice.getAll();
        }
    }

    @GetMapping("/{bookId}")
    public Book get(@PathVariable String bookId){
        return bookservice.get(bookId);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book){
        return this.bookservice.addBook(book);
    }

    @PutMapping({"/{bookId}"})
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book){
        Book ret = this.bookservice.updateBook(bookId, book);
        return ret;
    }

    @DeleteMapping({"/{bookId}"})
    public Book deleteBook(@PathVariable String bookId){
        return this.bookservice.deleteBook(bookId);
         
    }

}
