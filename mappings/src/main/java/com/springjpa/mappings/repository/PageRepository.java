package com.springjpa.mappings.repository;

import com.springjpa.mappings.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Pages, Long> {
    List<Pages> findByBookId(Long bookId);
}