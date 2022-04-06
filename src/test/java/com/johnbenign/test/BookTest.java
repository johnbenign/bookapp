package com.johnbenign.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.johnbenign.book.dto.Book;
import com.johnbenign.book.service.BookService;
import com.johnbenign.book.service.impl.BookServiceImpl;
import com.johnbenign.dto.ResponseDTO;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
public class BookTest
{
	private static final Logger logger = Logger.getLogger(BookTest.class.getName());
	
	@Autowired
	private BookService service;
	
	//@Test
	public void createBook()
	{
		Book book = new Book();
		
		book.setAuthor("Benign");
		book.setCountry("Nigeria");
		book.setGender("MALE");
		book.setIsbn("2343-5434-676582");
		book.setPublisher("Ben PLS");
		book.setTitle("How to make money");
		
		ResponseDTO response = service.createBook(book);
		
		assertNotNull(response, "response should not be null");
		assertTrue(response.getResult(), "result should be true");
	}
	
	//@Test
	public void getAllBooks()
	{
		List<Book> books = service.getAllBooks();
		
		books.forEach(book -> logger.info("book title: " + book.getTitle()));
	}
	
	//@Test
	public void getBookById()
	{
		Book book = service.getBookById("2343-5434-676582");
		
		assertNotNull(book, "book should not be null");
	}
	
	@Test
	public void deleteBook()
	{
		String isbn = "2343-5434-676582";
		
		ResponseDTO response = service.deleteBookById(isbn);
		
		assertNotNull(response, "response should not be null");
		assertTrue(response.getResult(), "result should be true");
	}
	
	//@Test
	public void updateBook()
	{
		Book book = new Book();
		
		book.setGender("FEMALE");
		book.setIsbn("2343-5434-676582");
		
		ResponseDTO response = service.updateBook(book);
		
		assertNotNull(response, "response should not be null");
		assertTrue(response.getResult(), "result should be true");
	}
}
