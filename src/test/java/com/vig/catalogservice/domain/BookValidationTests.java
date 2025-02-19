package com.vig.catalogservice.domain;

import java.util.Set;

import javax.xml.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTests {

    private static jakarta.validation.Validator validator;

    @BeforeAll
    static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectValidationSucceeeds(){
        var book = new Book("1234567890", "some", "Same", 9.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenAllFieldsNotCorrectValidationFails(){
        var book = new Book("1234567890A", "some", "Same", 9.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("ISBN1 should be in valid format");
    }

    
}
