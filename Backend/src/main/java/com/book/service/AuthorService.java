package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.AuthorDemo;
import com.book.repository.AuthorRepository;
@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public AuthorDemo getAuthorById(int id) {
		return authorRepository.findById(id);
	}

	public AuthorDemo getAuthorByName(String name) {
		return authorRepository.findByName(name);
	}

	public AuthorDemo saveAuthor(AuthorDemo author) {
		return authorRepository.save(author);
	}

}
