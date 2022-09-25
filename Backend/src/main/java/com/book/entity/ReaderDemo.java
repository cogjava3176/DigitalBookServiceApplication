package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class ReaderDemo {
	
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

		@NotBlank(message = "name cannot be blank#######")
		private String name;

		@Email(message = "email should be in correct format")
		private String email;

		private String password;
}
