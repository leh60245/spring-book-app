package com.example.book.mapper;

import com.example.book.domain.Book;
import com.example.book.dto.BookDTO;

public class BookMapper {

    public static Book toEntity(BookDTO.Post dto) {
        return new Book(null, dto.getTitle(), dto.getSubTitle(), dto.getAuthor(), dto.getPublisher(), Book.Status.AVAILABLE);
    }

    public static void updateEntity(Book book, BookDTO.Put dto) {
        book.setTitle(dto.getTitle());
        book.setSubTitle(dto.getSubTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setStatus(dto.getStatus());
    }

    public static BookDTO.Response toResponse(Book book) {
        return new BookDTO.Response(
                book.getId(),
                book.getTitle(),
                book.getSubTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getStatus()
        );
    }
}
