package com.vig.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn){
        super("Book with " + isbn + " a already exists");
    }   
}
