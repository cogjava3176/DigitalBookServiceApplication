package com.book.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.controller.BaseController;

@ExtendWith(MockitoExtension.class)
public class BaseControllerTest {
	


	@InjectMocks
	BaseController baseController;

	@Test
	void testHandleOrderNotFound() {
		Exception ex = new Exception();
		assertEquals("something went wrong", baseController.handleBookNotFound(ex));

	}

}
