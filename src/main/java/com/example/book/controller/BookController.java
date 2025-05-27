package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.service.BookService;
import com.example.book.dto.BookDTO.*;
import com.example.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public List<Response> getBooks() {
        return bookService.findBooks().stream().map(Response::from).toList();
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return Response.from(book);
    }

    @PostMapping
    public Response createBook(@RequestBody Post dto) {
        Book book = new Book(null, dto.getTitle(), dto.getSubTitle(), dto.getAuthor(), dto.getPublisher(), Book.Status.AVAILABLE);
        Book saved = bookService.insertBook(book);
        return Response.from(saved);
    }

    @PutMapping("/{id}")
    public Response updateBook(@PathVariable Long id, @RequestBody Put dto) {
        Book book = bookService.findBook(id);
        BookMapper.updateEntity(book, dto);
        Book updated = bookService.updateBook(book);
        return Response.from(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
