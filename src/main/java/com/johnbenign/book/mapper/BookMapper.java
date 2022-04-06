package com.johnbenign.book.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.johnbenign.book.dto.Book;

@Mapper(componentModel = "spring")

public interface BookMapper
{
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateBookFromDTO(Book book, @MappingTarget Book entity);
}
