package com.book.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.controller.ReaderController;
import com.book.entity.PurchasedBook;
import com.book.entity.ReaderDemo;
import com.book.service.PurchasedBookService;

@ExtendWith(MockitoExtension.class)
public class ReaderControllerTest {
	
	@Mock
	PurchasedBookService purchasedBookService;
	@InjectMocks
	ReaderController readerController;

	@Test
	void testGetAllPurchasedBooks() {
		List<PurchasedBook> purchasedBookList = new ArrayList<>();
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		ReaderDemo reader = new ReaderDemo();
		reader.setId(1);
		reader.setName("chaitali");
		reader.setEmail("chaitali@.com");
		purchasedBook.setReader(reader);
		purchasedBookList.add(purchasedBook);
		when(purchasedBookService.getPurchasedBook("chaitali@.com")).thenReturn(purchasedBookList);
		assertEquals(purchasedBookList, readerController.getAllPurchasedBooks("chaitali@.com"));
	}


}
