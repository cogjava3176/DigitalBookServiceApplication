package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class PurchasedBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Min(value = 1, message = "book id canot be less than 1")
	private int bookId;

	@ManyToOne
	private ReaderDemo reader;


}
