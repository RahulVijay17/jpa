package com.springjpa.mappings.controller;

import com.springjpa.mappings.dto.BookDto;
import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.exception.BookNotFoundException;
import com.springjpa.mappings.service.BookService;
import com.springjpa.mappings.service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final PageService pageService;
    public BookController(BookService bookService, PageService pageService) {
        this.bookService = bookService;
        this.pageService = pageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        try {
            BookDto bookDto = bookService.getBookById(id);
            return ResponseEntity.ok(bookDto);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto createdBookDto = bookService.createBook(bookDto);
        return new ResponseEntity<>(createdBookDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        try {
            BookDto updatedBook = bookService.updateBook(id, bookDto);
            return ResponseEntity.ok(updatedBook);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> bookDtos = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }

}