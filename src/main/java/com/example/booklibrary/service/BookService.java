package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo repo;
    @Autowired
    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.getAllBooks();
    }

    public Book getBookByIsbn(String isbn) {
        return repo.getBookByIsbn(isbn);
    }

    public Book addBook(Book title) {
        return repo.addBook(title);
    }

    public void deleteBooks(String isbn) {
        repo.deleteBook(isbn);
    }
}
