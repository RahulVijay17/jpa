package com.springjpa.mappings.service;

import com.springjpa.mappings.dto.PageDto;

import java.util.List;

public interface PageService {

    void updatePageWithBookId(Long pageId, Long bookId);

    List<PageDto> getPagesByBookId(Long bookId);
}
