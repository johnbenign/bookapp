package com.johnbenign.book.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbenign.book.dto.Book;
import com.johnbenign.book.mapper.BookMapper;
import com.johnbenign.book.repository.BookRepository;
import com.johnbenign.book.service.BookService;
import com.johnbenign.dto.ResponseDTO;

@Service
public class BookServiceImpl implements BookService
{
	private static final Logger logger = Logger.getLogger(BookServiceImpl.class.getName());
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookMapper mapper;
	
	public ResponseDTO createBook(Book book)
	{
		ResponseDTO response = new ResponseDTO();
		
		try
		{
			if(book == null)
			{
				logger.info("book object is null");
				
				throw new Exception("book object is null");
			}
			
			Book bookEntity = repository.save(book);
			
			logger.info(" book created successfully!");
			response.setResult(true);
			response.setResponse(bookEntity);
		}
		catch(Exception e)
		{
			logger.severe(" --- error: " + e.getMessage() + e);
			
			response.setErrorMsg(e.getMessage());
			response.setResponse(e);
			response.setResult(false);
		}
		
		return response;
	}
	
	public List<Book> getAllBooks()
	{
		List<Book> books = repository.findAll();
		
		return books;
	}
	
	public Book getBookById(String isbn)
	{
		Book book = null;
		
		try
		{
			book = repository.findById(isbn).get();
			
			//if(Optional.)
		}
		catch(Exception e)
		{
			logger.severe("--- error: " + e.getMessage() + e);
		}
		
		return book;
	}
	
	public ResponseDTO deleteBookById(String isbn)
	{
		ResponseDTO response = new ResponseDTO();
		
		try
		{
			repository.deleteById(isbn);
			
			response.setResult(true);
			
			logger.info(" --- book removed successfully! --- ");
		}
		catch(Exception e)
		{
			logger.severe("error: " + e.getMessage() + e);
			
			response.setErrorMsg(e.getMessage());
			response.setResponse(e);
			response.setResult(false);
		}
		
		return response;
	}
	
	@Transactional
	@Override
	public ResponseDTO updateBook(Book book)
	{
		ResponseDTO response = new ResponseDTO();
		
		try
		{
			if(book == null)
			{
				logger.info("book object is null");
				
				throw new Exception("book is null");
			}
			
			if(book.getIsbn().isBlank())
			{
				logger.info(" no isbn supplied!");
				
				throw new Exception("no value for isbn present");
			}
			
			Book bookEntity = repository.findById(book.getIsbn()).get();
			
			mapper.updateBookFromDTO(book, bookEntity);
			
			Book updatedBook = repository.save(bookEntity);
			
			logger.info("book updated successfully!");
			response.setResult(true);
			response.setResponse(updatedBook);
		}
		catch(Exception e)
		{
			logger.severe("error: " + e.getMessage() + e);
			
			response.setErrorMsg(e.getMessage());
			response.setResponse(e);
			response.setResult(false);
		}
		
		return response;
	}
}