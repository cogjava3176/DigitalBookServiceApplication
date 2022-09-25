package com.book.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.entity.AuthorDemo;
import com.book.entity.BookDemo;
import com.book.entity.Category;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class BookTest {
	
	@Test	
	public void booktest() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("Rmujumdar");

		BookDemo book = new BookDemo();
		book.setId(1);
		book.setCategory(Category.Historical);
		book.setContent("The war");
		book.setLogo("war.img");
		book.setPrice(2400);
		book.setPublishedDate(localDateTime.toLocalDate());
		book.setPublisher("publisher3");
		book.setTitle("Panipat");
		book.setActive(true);
		book.setAuthor(author);
		
		assertEquals(1, book.getId());
	}
}