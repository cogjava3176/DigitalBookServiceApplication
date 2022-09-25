package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.BookDemo;

public interface BookRepository  extends JpaRepository<BookDemo, Integer> {
}


