package com.vig.catalogservice.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.vig.catalogservice.domain.Book;
import com.vig.catalogservice.domain.BookRepository;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;


    public BookDataLoader(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadTestData(){
        bookRepository.deleteAll();
        var book1 = Book.of("1234567890", "title1", "author1", 9.99);
        var book2 = Book.of("0987654321", "title2", "author2", 9.99);
        bookRepository.saveAll(List.of(book1,book2));
    }
}
