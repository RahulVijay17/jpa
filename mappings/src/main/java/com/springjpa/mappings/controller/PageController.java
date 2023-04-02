package com.springjpa.mappings.controller;

import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.exception.BookNotFoundException;
import com.springjpa.mappings.exception.PageNotFoundException;
import com.springjpa.mappings.model.Pages;
import com.springjpa.mappings.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PageController {

    @Autowired
    private PageService pageService;

    @PutMapping("/pages/{id}/book")
    public ResponseEntity<String> updatePageBook(@PathVariable Long id, @RequestParam Long bookId) {
        try {
            pageService.updatePageWithBookId(id, bookId);
            return ResponseEntity.ok("Page book updated successfully");
        } catch (PageNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found");
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<PageDto>> getPagesByBookId(@PathVariable Long bookId) {
        List<PageDto> pages = pageService.getPagesByBookId(bookId);
        if (pages.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pages);
    }
}
