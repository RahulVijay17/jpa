package com.springjpa.mappings.mapper;

import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.model.Pages;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PageMapper {

    PageDto toDto(Pages page);

    Pages toEntity(PageDto pageDto);
}