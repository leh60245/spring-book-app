package com.example.book.service;

import com.example.book.domain.Book;

import java.util.List;

public interface BookService {

    Book insertBook(Book book);
    List<Book> findBooks();
    Book findBook(Long id);
    Book updateBook(Book book);
    void deleteBook(Long id);
}
