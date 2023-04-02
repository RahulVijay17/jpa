package com.springjpa.mappings.service;

import com.springjpa.mappings.dto.BookDto;
import com.springjpa.mappings.dto.PageDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto updateBook(Long id, BookDto bookDto);

    void deleteBook(Long id);
}
