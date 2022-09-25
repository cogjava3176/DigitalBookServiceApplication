package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.entity.AuthorDemo;

public interface AuthorRepository extends JpaRepository<AuthorDemo, Integer> {
    @Query("select author from AuthorDemo author where author.id =?1")
    AuthorDemo findById(int autherId);

    AuthorDemo findByName(String name);
}
