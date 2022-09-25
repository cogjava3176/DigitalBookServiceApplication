package com.book.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.entity.AuthorDemo;
import com.book.entity.BookDemo;
import com.book.entity.Category;
import com.book.repository.BookRepository;
import com.book.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	void testSaveBook() {
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
		when(bookRepository.save(book)).thenReturn(book);
		bookService.saveBook(book);
		assertEquals(1, book.getId());
	}

	@Test
	void testGetBooks() {
		List<BookDemo> bookList = new ArrayList<>();
		LocalDateTime localDateTime = LocalDateTime.now();
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("Rmujumdar");

		BookDemo book1 = new BookDemo();
		book1.setId(1);
		book1.setCategory(Category.Historical);
		book1.setContent("The war");
		book1.setLogo("war.img");
		book1.setPrice(2400);
		book1.setPublishedDate(localDateTime.toLocalDate());
		book1.setPublisher("publisher3");
		book1.setTitle("Panipat");
		book1.setActive(true);
		book1.setAuthor(author);

		BookDemo book2 = new BookDemo();
		book2.setId(2);
		book2.setCategory(Category.Fiction);
		book2.setContent("theghost");
		book2.setLogo("none.img");
		book2.setPrice(1500);
		book2.setPublishedDate(localDateTime.toLocalDate());
		book2.setPublisher("publisher2");
		book2.setTitle("Draculla");
		book2.setActive(true);
		book2.setAuthor(author);

		bookList.add(book1);
		bookList.add(book2);

		when(bookRepository.findAll()).thenReturn(bookList);
		Iterable<BookDemo> List = bookService.getBooks();
		assertEquals(bookList,List);

	}

	@Test
	void testGetBooksForException() {
		assertThrows(IllegalArgumentException.class, () -> {
			java.util.List<BookDemo> bookList = null;
			when(bookRepository.findAll()).thenReturn(bookList);
			bookService.getBooks();
		});
	}

}
