package com.example.booklibrary.repo;

import com.example.booklibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookRepo {


    Map<String, Book> bookMap = new HashMap<>();
    
    public BookRepo(){}

    public List<Book> getAllBooks(){
        return List.copyOf(bookMap.values());
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public Book addBook(Book title) {
         bookMap.put(title.getIsbn(), title);
         return title;
    }

    public void deleteBook(String isbn) {
        bookMap.remove(isbn);
    }

}
