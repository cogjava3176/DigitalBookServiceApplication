package com.book.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.entity.AuthorDemo;
import com.book.entity.PurchasedBook;
import com.book.entity.ReaderDemo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class PurchasedBookTest {
	

	@Test
	public void purchasedbooktest() {
		
		ReaderDemo reader = new ReaderDemo();
		reader.setId(4);
		reader.setName("chait");
		reader.setEmail("chait@gmai.com");
		
		
		PurchasedBook purchasedbook=new PurchasedBook();
		purchasedbook.setId(4);
		purchasedbook.setBookId(4);
		
	
		assertEquals(4, purchasedbook.getId());
		assertEquals(4, purchasedbook.getBookId());

}
}
	
	


