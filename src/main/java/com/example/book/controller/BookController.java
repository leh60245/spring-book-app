package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public List<Book> getBooks() {
        return bookService.findBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBook(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @PatchMapping("/{id}")
    public Book updateBookStatus(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book.getStatus());
    }
}
