package com.johnbenign.book.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.johnbenign.book.dto.Book;
import com.johnbenign.book.service.BookService;
import com.johnbenign.dto.ResponseDTO;

@RestController
@RequestMapping("/book")
public class BookController
{
	private static final Logger logger = Logger.getLogger(BookController.class.getName());
	
	@Autowired
	private BookService service;
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> createBook(@RequestBody Book book)
	{
		ResponseDTO response = service.createBook(book);
		
		if(response.getResult())
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books = service.getAllBooks();
		
		return ResponseEntity.ok(books);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{isbn}")
	public ResponseEntity<Book> getBookById(@PathVariable String isbn)
	{
		Book book = service.getBookById(isbn);
		
		return ResponseEntity.ok(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{isbn}")
	public ResponseEntity<ResponseDTO> updateBook(@RequestBody Book book, @PathVariable String isbn)
	{
		
		book.setIsbn(isbn);
		
		ResponseDTO response = service.updateBook(book);
		
		if(response.getResult())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{isbn}")
	public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable String isbn)
	{
		ResponseDTO response = service.deleteBookById(isbn);
		
		if(response.getResult())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
