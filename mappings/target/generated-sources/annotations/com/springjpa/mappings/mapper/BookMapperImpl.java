package com.springjpa.mappings.mapper;

import com.springjpa.mappings.dto.BookDto;
import com.springjpa.mappings.dto.PageDto;
import com.springjpa.mappings.model.Book;
import com.springjpa.mappings.model.Pages;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T22:48:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setPages( pagesListToPageDtoList( book.getPages() ) );

        return bookDto;
    }

    @Override
    public Book toEntity(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setAuthor( bookDto.getAuthor() );
        book.setPages( pageDtoListToPagesList( bookDto.getPages() ) );

        return book;
    }

    protected PageDto pagesToPageDto(Pages pages) {
        if ( pages == null ) {
            return null;
        }

        PageDto pageDto = new PageDto();

        pageDto.setId( pages.getId() );
        if ( pages.getPageNumber() != null ) {
            pageDto.setPageNumber( pages.getPageNumber() );
        }
        pageDto.setContent( pages.getContent() );

        return pageDto;
    }

    protected List<PageDto> pagesListToPageDtoList(List<Pages> list) {
        if ( list == null ) {
            return null;
        }

        List<PageDto> list1 = new ArrayList<PageDto>( list.size() );
        for ( Pages pages : list ) {
            list1.add( pagesToPageDto( pages ) );
        }

        return list1;
    }

    protected Pages pageDtoToPages(PageDto pageDto) {
        if ( pageDto == null ) {
            return null;
        }

        Pages pages = new Pages();

        pages.setId( pageDto.getId() );
        pages.setPageNumber( pageDto.getPageNumber() );
        pages.setContent( pageDto.getContent() );

        return pages;
    }

    protected List<Pages> pageDtoListToPagesList(List<PageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Pages> list1 = new ArrayList<Pages>( list.size() );
        for ( PageDto pageDto : list ) {
            list1.add( pageDtoToPages( pageDto ) );
        }

        return list1;
    }
}
