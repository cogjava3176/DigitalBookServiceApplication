package com.book.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.controller.BookController;
import com.book.entity.AuthorDemo;
import com.book.entity.BookDemo;
import com.book.entity.Category;
import com.book.service.AuthorService;
import com.book.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	@Mock
	BookService bookService;

	@Mock
	AuthorService authorService;

	@InjectMocks
	BookController bookController;
	
	@Test
	void testSaveBook() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("Jawaharlal Nehru");
		BookDemo book = new BookDemo();
		book.setId(1);
		book.setCategory(Category.AutoBiography);
		book.setContent("This is an autobiography");
		book.setLogo("none");
		book.setPrice(1200);
		book.setPublishedDate(localDateTime.toLocalDate());
		book.setPublisher("publisher1");
		book.setTitle("An AutoBiography");
		book.setActive(true);
		book.setAuthor(author);
		when(authorService.getAuthorById(1)).thenReturn(author);
		when(bookService.saveBook(book)).thenReturn(book);
		Integer savedBookId = bookController.saveBook(book, 1);
		assertEquals(1, savedBookId);
	}

	@Test
	void testGetBooks() {
		List<BookDemo> bookList = new ArrayList<>();
		LocalDateTime localDateTime = LocalDateTime.now();
		AuthorDemo author = new AuthorDemo();
		author.setId(1);
		author.setName("Jawaharlal Nehru");

		BookDemo book1 = new BookDemo();
		book1.setId(1);
		book1.setCategory(Category.AutoBiography);
		book1.setContent("This is an autobiography");
		book1.setLogo("none");
		book1.setPrice(1200);
		book1.setPublishedDate(localDateTime.toLocalDate());
		book1.setPublisher("publisher1");
		book1.setTitle("An AutoBiography");
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

		Iterable<BookDemo> books = bookList;
		when(bookService.getBooks()).thenReturn(books);
		List<BookDemo> BookList1 = bookController.getBooks("Fiction", "Jawaharlal Nehru", 1200f, "publisher2");
		List<BookDemo> BookList2 = bookController.getBooks("Fiction", "Jawaharlal Nehru", null, "publisher2");
		List<BookDemo> BookList3 = bookController.getBooks("Fiction", null , 1500f, "publisher1");
		assertEquals(books, BookList1);
		assertEquals(books, BookList2);
		assertEquals(books, BookList3);
		
		List<BookDemo> nullBookList = new ArrayList<>();
		Iterable<BookDemo> emptyBooksList = nullBookList;
		when(bookService.getBooks()).thenReturn(emptyBooksList);
		List<BookDemo> actualBookList4 = bookController.getBooks("Biography", null , 500f, "manga");
		assertEquals(emptyBooksList, actualBookList4);

	}


}
