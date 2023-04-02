package com.springjpa.mappings.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long message) {
        super(String.valueOf(message));
    }
}