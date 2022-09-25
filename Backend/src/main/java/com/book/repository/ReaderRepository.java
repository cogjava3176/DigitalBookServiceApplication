package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.ReaderDemo;

public interface ReaderRepository extends JpaRepository<ReaderDemo, Integer> {

    ReaderDemo getByEmail(String email);

    ReaderDemo getFirstByEmailAndPassword(String email, String password);
}
