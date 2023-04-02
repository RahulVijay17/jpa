package com.jpa.onetoone.repository;

import com.jpa.onetoone.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
