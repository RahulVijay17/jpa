package com.springjpa.mappings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private List<PageDto> pages;
    public BookDto(String author, String title) {
        this.author = author;
        this.title = title;
    }
    // getters and setters
}