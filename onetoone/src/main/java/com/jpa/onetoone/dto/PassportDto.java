package com.jpa.onetoone.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportDto {
    private Long id;
    private String number;
    private LocalDate expirationDate;

    // constructor, getters, and setters
}