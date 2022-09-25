package com.book.controller;

import java.util.List;

import com.book.entity.ReaderDemo;
import com.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.book.entity.PurchasedBook;
import com.book.service.PurchasedBookService;

@RestController
@RequestMapping("/readers")


public class ReaderController {

	@Autowired
	PurchasedBookService purchasedBookService;

	@Autowired
	ReaderService readerService;
	
	@GetMapping("/{emailId}/books")
	public List<PurchasedBook> getAllPurchasedBooks(@PathVariable("emailId") String email) {
		return purchasedBookService.getPurchasedBook(email);

	}

	@PostMapping("/signup")
	public ReaderDemo signup(@RequestBody ReaderDemo user) throws Exception {
		ReaderDemo reader = readerService.getByEmail(user.getEmail());
		if (reader != null) {
			throw new Exception("User email was existed!");
		}
		return readerService.saveReader(user);
	}

	@GetMapping("/login")
	public ReaderDemo login(@RequestParam String email, @RequestParam String password) throws Exception {
		ReaderDemo reader = readerService.login(email, password);
//		if (reader == null) {
//			throw new Exception("Wrong email or password");
//		}
		return reader;
	}

}
