package com.example.arch_6.controller;

import com.example.arch_6.model.Book;
import com.example.arch_6.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @QueryMapping
    public List<Book> books(@Argument int count, @Argument int pageId) {
        return bookRepository.findAll(Pageable.ofSize(count).withPage(pageId)).stream().toList();
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String authorName, @Argument String genre) {
        Book book = new Book();
        book.setGenre(genre);
        book.setName(title);
        book.setAuthor(authorName);
        book = bookRepository.save(book);

        return book;
    }

    @PostConstruct
    public void postConstruct() {
        Book book = new Book();
        book.setGenre("Genre1");
        book.setName("Book1");
        book.setAuthor("Author1");
        book = bookRepository.save(book);
        bookRepository.save(book);
    }
}
