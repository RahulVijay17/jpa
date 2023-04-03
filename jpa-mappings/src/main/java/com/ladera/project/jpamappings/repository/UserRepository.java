package com.ladera.project.jpamappings.repository;

import com.ladera.project.jpamappings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
