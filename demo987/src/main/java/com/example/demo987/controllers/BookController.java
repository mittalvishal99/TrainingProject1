package com.example.demo987.controllers;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<BookEntity>> getBooks()
	{
		List<BookEntity> list=bookService.getBooks();;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<BookEntity> getBook(@PathVariable("id") int id)
	{
		BookEntity b=bookService.getBook(id);
		if(b==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(b));
		}
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
