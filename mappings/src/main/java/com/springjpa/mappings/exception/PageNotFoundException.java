package com.springjpa.mappings.exception;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(Long id) {
        super("Could not find page with id: " + id);
    }
}