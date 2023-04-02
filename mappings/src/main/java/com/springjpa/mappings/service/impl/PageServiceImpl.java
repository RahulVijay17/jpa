package com.springjpa.mappings.service.impl;

import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.exception.BookNotFoundException;
import com.springjpa.mappings.exception.PageNotFoundException;
import com.springjpa.mappings.mapper.PageMapper;
import com.springjpa.mappings.model.Book;
import com.springjpa.mappings.model.Pages;
import com.springjpa.mappings.repository.BookRepository;
import com.springjpa.mappings.repository.PageRepository;
import com.springjpa.mappings.service.BookService;
import com.springjpa.mappings.service.PageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PageServiceImpl implements PageService {
    private PageRepository pageRepository;
    private BookRepository bookRepository;
    private PageMapper pageMapper;

    @Override
    public void updatePageWithBookId(Long pageId, Long bookId) {
        Pages page = pageRepository.findById(pageId).orElseThrow(() -> new PageNotFoundException(pageId));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        page.setBook(book);
        pageRepository.save(page);
    }

    @Override
    public List<PageDto> getPagesByBookId(Long bookId) {
            List<Pages> pages = pageRepository.findByBookId(bookId);
            if (pages.isEmpty()) {
                return Collections.emptyList();
            }
            return pages.stream()
                    .map(pageMapper::toDto)
                    .collect(Collectors.toList());
        }
}



