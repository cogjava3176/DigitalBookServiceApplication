package com.book.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.entity.AuthorDemo;
import com.book.repository.AuthorRepository;
import com.book.service.AuthorService;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

	@Mock
	AuthorRepository authorRepository;
	
	@InjectMocks
	AuthorService authorService;
	
	@Test
	void testGetAuthorById() {
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("chaitali");
		
		when(authorRepository.findById(1)).thenReturn(author);
		AuthorDemo actualAuthor = authorService.getAuthorById(1);	
		assertEquals(author, actualAuthor);
	}
	
	@Test
	void testSaveAuthor() {
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("chaitali");
		
		when(authorRepository.save(author)).thenReturn(author);
		AuthorDemo actualAuthor = authorService.saveAuthor(author);
		assertEquals(author, actualAuthor);
	}

}
