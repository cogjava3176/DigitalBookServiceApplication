package com.book.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.controller.AuthorController;
import com.book.entity.AuthorDemo;
import com.book.service.AuthorService;



@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {
	@Mock
	AuthorService authorService;
	
	@InjectMocks
	AuthorController authorController;

	@Test
	void testSaveAuthor() {
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("Ram");
		
		when(authorService.saveAuthor(author)).thenReturn(author);
		int savedAuthorId = authorController.saveAuthor(author).getId();
		assertEquals(1, savedAuthorId);
	}

}
