package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService service;
    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return service.getBookByIsbn(isbn);
    }
    @PostMapping
    public Book addBook(@RequestBody Book title){
        return service.addBook(title);
    }
    @DeleteMapping(path = "{isbn}")
    public void deleteBook(@PathVariable String isbn){
        service.deleteBooks(isbn);
    }

}
