package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book insertBook(Book book) {
        book.setStatus(Book.Status.AVAILABLE);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("책을 찾을 수 없습니다: id=" + id));
    }

    @Override
    public Book updateBook(Long id, Book book) {
        // 책을 가져온다.
        Book b = findBook(id);
        // 책의 내용을 변경한다.
        b.setTitle(book.getTitle());
        b.setSubTitle(book.getSubTitle());
        b.setAuthor(book.getAuthor());
        b.setPublisher(book.getPublisher());
        b.setStatus(book.getStatus());
        // 변경된 책을 저장한다.
        return bookRepository.save(b);
    }


    @Override
    public Book updateBook(Long id, Book.Status status) {
        Book b = findBook(id);
        b.setStatus(status);
        return bookRepository.save(b);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
