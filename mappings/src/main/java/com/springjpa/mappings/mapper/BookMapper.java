package com.springjpa.mappings.mapper;

import com.springjpa.mappings.dto.BookDto;
import com.springjpa.mappings.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

}