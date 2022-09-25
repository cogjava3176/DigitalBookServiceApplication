package com.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.AuthorDemo;
import com.book.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
		@Autowired
		AuthorService authorService;

		@PostMapping("/signup")
		
		public AuthorDemo saveAuthor(@Valid @RequestBody AuthorDemo author) {
			return authorService.saveAuthor(author);
		}

	}


