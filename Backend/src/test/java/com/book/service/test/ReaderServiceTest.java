package com.book.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.entity.ReaderDemo;
import com.book.repository.ReaderRepository;
import com.book.service.ReaderService;

@ExtendWith(MockitoExtension.class)
public class ReaderServiceTest {
	
	@InjectMocks
	ReaderService readerService;
	
	@Mock
	ReaderRepository readerRepository;

	@Test
	void testSaveReader() {
		ReaderDemo reader = new ReaderDemo();
		reader.setId(1);
		reader.setName("Chaitali");
		reader.setEmail("chaitali@.com");
		when(readerRepository.save(reader)).thenReturn(reader);
		assertEquals(1, readerService.saveReader(reader).getId());
	}

}
