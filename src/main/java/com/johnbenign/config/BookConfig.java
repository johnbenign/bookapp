package com.johnbenign.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.johnbenign.book.dto", "com.johnbenign.book.mapper"})
public class BookConfig
{
	
}
