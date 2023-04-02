package com.springjpa.mappings.service.impl;

import com.springjpa.mappings.dto.BookDto;
import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.exception.BookNotFoundException;
import com.springjpa.mappings.mapper.BookMapper;
import com.springjpa.mappings.mapper.PageMapper;
import com.springjpa.mappings.model.Book;
import com.springjpa.mappings.model.Pages;
import com.springjpa.mappings.repository.BookRepository;
import com.springjpa.mappings.repository.PageRepository;
import com.springjpa.mappings.service.BookService;
import com.springjpa.mappings.service.PageService;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hibernate.jpa.HibernateHints.HINT_FETCH_SIZE;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private PageRepository pageRepository;
    private PageMapper pageMapper;
    private PageService pageService;

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.getPages().stream().collect(Collectors.toList());
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book = bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book = bookRepository.save(book);
        return bookMapper.toDto(book);
    } //only to update book

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }
}
