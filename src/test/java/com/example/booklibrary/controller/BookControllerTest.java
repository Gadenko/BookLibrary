package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired

    private WebTestClient testClient;

    @Test
    void addBook() {
        //Given
        Book book = new Book("w","2");
        //When
        Book actual = testClient.post()
                .uri("http://localhost:" + port + "/book")
                .bodyValue(book)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();
        //Then
        Book expected = new Book("w","2");
        assertEquals(expected, actual);
    }

    @Test
    void getBookByIsbn() {
        Book book = new Book("hey","123");
        testClient.post()
                .uri("http://localhost:" + port + "/book")
                .bodyValue(book)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();
        Book actual = testClient.get()
                .uri("http://localhost:" + port + "/book/123")
                .exchange()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        Book expected = new Book("hey", "123");
        Assertions.assertEquals(expected, actual);
    }
}