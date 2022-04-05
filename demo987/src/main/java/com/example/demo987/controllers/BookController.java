package com.example.demo987.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo987.entities.BookEntity;
import com.example.demo987.services.BookService;

@RestController
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookEntity> getBooks()
	{
		return this.bookService.getBooks();
	}
	
	@GetMapping("/books/{id}")
	public BookEntity getBook(@PathVariable("id") int id)
	{
		return this.bookService.getBook(id);
	}
	
	@PostMapping("/books")
	
		public BookEntity addBook(@RequestBody BookEntity b)
		{
			BookEntity book=this.bookService.addBook(b);
			return book;
		}
	@DeleteMapping("/books/{id}")
	
		public void deleteBook(@PathVariable("id") int id)
		{
			this.bookService.deletebook(id);
		}
	
	@PutMapping("/book/{id}")
	 
		public BookEntity update(@RequestBody BookEntity b , @PathVariable("id") int id)
		{
				this.bookService.updateBook(b,id);
				return b;
		}
	
}
