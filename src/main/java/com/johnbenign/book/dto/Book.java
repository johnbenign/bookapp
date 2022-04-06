package com.johnbenign.book.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Book
{
	@Column
	@Id
	private String isbn;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String publisher;
	
	@Column
	private String country;
	
	@Column
	private String gender;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
