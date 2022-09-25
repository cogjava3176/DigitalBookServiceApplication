package com.book.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.entity.ReaderDemo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class ReaderTest {
	@Test
	public void readertest() {
		ReaderDemo readerdemo = new ReaderDemo();
		Integer id =1;
		String name = "chaitali";
		String email="chaitali";
		
		readerdemo.setId(id);
		readerdemo.setName(name);
		readerdemo.setEmail(email);
		
		assertEquals(id, readerdemo.getId());
		assertEquals(name, readerdemo.getName());
		assertEquals(name, readerdemo.getEmail());
		

	}	
	

}
