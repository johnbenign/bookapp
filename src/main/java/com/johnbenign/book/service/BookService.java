package com.johnbenign.book.service;

import java.util.List;

import com.johnbenign.book.dto.Book;
import com.johnbenign.dto.ResponseDTO;

public interface BookService
{
	public ResponseDTO createBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(String isbn);
	public ResponseDTO updateBook(Book book);
	public ResponseDTO deleteBookById(String isbn);
}
