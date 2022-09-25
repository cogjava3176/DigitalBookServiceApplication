package com.book.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.entity.PurchasedBook;
import com.book.entity.ReaderDemo;
import com.book.repository.PurchasedBookRepository;
import com.book.service.PurchasedBookService;

@ExtendWith(MockitoExtension.class)
public class PurchasedBookServiceTest {
	
	@InjectMocks
	PurchasedBookService purchasedBookService;
	
	@Mock
	PurchasedBookRepository purchasedBookRepository;
	
	@Test
	void testSavePurchasedBook() {
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		ReaderDemo reader = new ReaderDemo();
		reader.setId(1);
		reader.setName("Chaitali");
		reader.setEmail("chaitali@.com");
		purchasedBook.setReader(reader);
		when(purchasedBookRepository.save(purchasedBook)).thenReturn(purchasedBook);
		assertEquals(1, purchasedBookService.savePurchasedBook(purchasedBook).getId());
	
	}
	@Test
	void testGetPurchasedBook() {
		List<PurchasedBook> purchasedBookList = new ArrayList<>();
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		ReaderDemo reader = new ReaderDemo();
		reader.setId(1);
		reader.setName("Chaitali");
		reader.setEmail("chaitali@.com");
		purchasedBook.setReader(reader);
		purchasedBookList.add(purchasedBook);
		when(purchasedBookRepository.findAll()).thenReturn(purchasedBookList);
		assertEquals(purchasedBookList, purchasedBookService.getPurchasedBook("chaitali@.com"));
		
	}

}
