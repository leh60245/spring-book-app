package com.example.book.dto;

import com.example.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BookDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {
        private String title;
        private String subTitle;
        private String author;
        private String publisher;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Put {
        private String title;
        private String subTitle;
        private String author;
        private String publisher;
        private Book.Status status;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Patch {
        private Book.Status status;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String subTitle;
        private String author;
        private String publisher;
        private Book.Status status;

        public static Response from(Book book) {
            return new Response(
                    book.getId(),
                    book.getTitle(),
                    book.getSubTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getStatus()
            );
        }
    }
}
