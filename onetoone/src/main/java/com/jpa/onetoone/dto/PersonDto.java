package com.jpa.onetoone.dto;

import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String name;
    private String email;
    private PassportDto passport;

    // constructor, getters, and setters
}
