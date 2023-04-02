package com.jpa.onetoone.repository;

import com.jpa.onetoone.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
