package com.book.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.entity.AuthorDemo;


@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class AuthorTest {
	
	@Test
	public void authortest() {
		AuthorDemo authordemo = new AuthorDemo();
		Integer id =1;
		String name = "chaitali";
		
		authordemo.setId(id);
		authordemo.setName(name);
		
		assertEquals(id, authordemo.getId());
		assertEquals(name, authordemo.getName());

}
}