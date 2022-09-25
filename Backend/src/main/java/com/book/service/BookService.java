package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookDemo;
import com.book.repository.BookRepository;
@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	
	public Iterable<BookDemo> getBooks() {
		Iterable<BookDemo> books = bookRepository.findAll();
		if (null != books) {
			return books;

		} else {
			throw new IllegalArgumentException("No book found!");
		}
	}

	public BookDemo saveBook(BookDemo book) {
		return bookRepository.save(book);
	}

}
