package com.vig.catalogservice.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
    
    @Id
    Long id,

    @Version
    int version,
    
    @NotBlank(message =  "The Book isbn must be defined")
    @Pattern(
        regexp = "^([0-9]{10}|[0-9]{13})$",
        message = "ISBN should be in valid format"
    )
    String isbn,
    @NotBlank(message =  "The Book title must be defined")
    String title,
    @NotBlank(message =  "The Book author must be defined")
    String author,
    @NotNull(message =  "The Book price must be defined")
    @Positive(message = "The book price must be greater than zero.")
    Double price,
    @CreatedDate
    Instant createdDate,
    @LastModifiedDate
    Instant lastModifiedDate
) {
    public static Book of(String isbn, String title, String author, Double price){
        return new Book(null, 0, isbn, title, author, price, null , null);
    }
    
}
