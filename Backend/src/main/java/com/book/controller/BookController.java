package com.book.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.AuthorDemo;
import com.book.entity.BookDemo;
import com.book.entity.PurchasedBook;
import com.book.entity.ReaderDemo;
import com.book.service.AuthorService;
import com.book.service.BookService;
import com.book.service.PurchasedBookService;
import com.book.service.ReaderService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PurchasedBookService purchasedBookService;

    @Autowired
    ReaderService readerService;


    @GetMapping("/search")

    public List<BookDemo> getBooks(@RequestParam(value = "category", required = false) String category,
                                   @RequestParam(value = "author", required = false) String authorName,
                                   @RequestParam(value = "price", required = false) Float price,
                                   @RequestParam(value = "publisher", required = false) String publisher) {
        log.debug("inside getBooks");
        List<BookDemo> bookList = Streamable.of(bookService.getBooks()).toList();
        List<BookDemo> sortedList = null;
        if (null != bookList) {
            sortedList = bookList.stream()
                                 .filter(b -> {
                                     if (category == null)
                                         return true;
                                     return b.getCategory().toString().equalsIgnoreCase(category);
                                 })
                                 .filter(b -> {
                                     if (authorName == null)
                                         return true;
                                     return b.getAuthor().getName().equalsIgnoreCase(authorName);
                                 })
                                 .filter(b -> {
                                     if (publisher == null)
                                         return true;
                                     return b.getPublisher().equalsIgnoreCase(publisher);
                                 })
                                 .filter(b -> {
                                     if (price == null)
                                         return true;
                                     return b.getPrice() == price;
                                 })
                                 .collect(Collectors.toList());
        }

        return sortedList;
    }


    @PostMapping("/author/{authorId}/books")
    public Integer saveBook(@Valid @RequestBody BookDemo book, @PathVariable("authorId") int authorId) throws Exception {
		AuthorDemo author = authorService.getAuthorById(authorId);
		if (null != author) {
			book.setAuthor(author);
			bookService.saveBook(book);
			return book.getId();
		} else {
			throw new Exception("Author not found!!");
		}
	}

    @PostMapping("/books/buy")
    Integer SavePurchasedBook(@Valid @RequestBody PurchasedBook purchasedBook) {
        ReaderDemo reader = purchasedBook.getReader();
        if (null != reader) {
            log.debug("reader is not empty");
            readerService.saveReader(reader);
            purchasedBook.setReader(reader);
        }
        return purchasedBookService.savePurchasedBook(purchasedBook).getId();
    }


}
