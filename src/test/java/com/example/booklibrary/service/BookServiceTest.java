package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repo.BookRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookRepo bookRepo = mock(BookRepo.class);
    private BookService bookService = new BookService(bookRepo);

    @Test
    void getAllBooks() {
        when(bookRepo.getAllBooks()).thenReturn(List.of(
                new Book("Mars Adventure", "542587-4589-9-88"),
                new Book("How you can create your favorite game", "1-2-1-111-1")
        ));

        List<Book> actual = bookService.getAllBooks();
        List<Book> expected = List.of(
                new Book("Mars Adventure", "542587-4589-9-88"),
                new Book("How you can create your favorite game", "1-2-1-111-1")
        );
        verify(bookRepo).getAllBooks();
        assertEquals(expected, actual);
    }

    @Test
    void getBookByIsbn() {
        when(bookRepo.getBookByIsbn("542587-4589-9-88")).thenReturn(
                new Book("Mars Adventure", "542587-4589-9-88"));

        Book actual = bookService.getBookByIsbn("542587-4589-9-88");
        Book expected = new Book("Mars Adventure", "542587-4589-9-88");

        verify(bookRepo).getBookByIsbn("542587-4589-9-88");
        assertEquals(expected,actual);

    }

    @Test
    void addBook() {
        when(bookRepo.addBook(new Book("Mars Adventure","542587-4589-9-88")))
                .thenReturn(new Book("Mars Adventure","542587-4589-9-88"));


        Book actual = bookService.addBook(new Book("Mars Adventure","542587-4589-9-88"));
        Book expected = new Book ("Mars Adventure","542587-4589-9-88");

        verify(bookRepo).addBook(new Book("Mars Adventure","542587-4589-9-88"));
        assertEquals(expected,actual);

    }

    @Test
    void deleteBooks() {
        doNothing().when(bookRepo).deleteBook("542587-4589-9-88");
    }
}