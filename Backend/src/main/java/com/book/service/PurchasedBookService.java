package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.PurchasedBook;
import com.book.repository.PurchasedBookRepository;

@Service
public class PurchasedBookService {
	
	@Autowired
	PurchasedBookRepository purchasedBookRepository;

	
	public PurchasedBook savePurchasedBook(PurchasedBook purchasedBook) {
		return purchasedBookRepository.save(purchasedBook);
	}

	public List<PurchasedBook> getPurchasedBook(String email) {
		List<PurchasedBook> sortedList = new ArrayList<>();
		Iterable<PurchasedBook> booklist = purchasedBookRepository.findAll();
		for (PurchasedBook book : booklist) {
			if (book.getReader().getEmail().equals(email)) {
				sortedList.add(book);
			}
		}

		return sortedList;

	}

}
