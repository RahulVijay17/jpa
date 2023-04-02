package com.springjpa.mappings.mapper;

import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.model.Pages;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T22:48:58+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class PageMapperImpl implements PageMapper {

    @Override
    public PageDto toDto(Pages page) {
        if ( page == null ) {
            return null;
        }

        PageDto pageDto = new PageDto();

        pageDto.setId( page.getId() );
        if ( page.getPageNumber() != null ) {
            pageDto.setPageNumber( page.getPageNumber() );
        }
        pageDto.setContent( page.getContent() );

        return pageDto;
    }

    @Override
    public Pages toEntity(PageDto pageDto) {
        if ( pageDto == null ) {
            return null;
        }

        Pages pages = new Pages();

        pages.setId( pageDto.getId() );
        pages.setPageNumber( pageDto.getPageNumber() );
        pages.setContent( pageDto.getContent() );

        return pages;
    }
}
