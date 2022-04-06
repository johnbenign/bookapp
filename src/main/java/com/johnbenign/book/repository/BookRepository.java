package com.johnbenign.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbenign.book.dto.Book;

public interface BookRepository extends JpaRepository<Book, String>
{
	
}
