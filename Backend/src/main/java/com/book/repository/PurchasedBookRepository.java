package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.PurchasedBook;

public interface PurchasedBookRepository extends JpaRepository<PurchasedBook, Integer> {


}
