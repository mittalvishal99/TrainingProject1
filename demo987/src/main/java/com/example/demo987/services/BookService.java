package com.example.demo987.services;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo987.entities.BookEntity;

@Service
public class BookService
{
	public static List<BookEntity> list=new ArrayList<>();
	
	static{
		list.add(new BookEntity(12,"MY BOOK","AUTHOR A"));
		list.add(new BookEntity(13,"HIS BOOK","AUTHOR B"));
		list.add(new BookEntity(14,"HER BOOK","AUTHOR C"));
		
	}
	
	public List<BookEntity> getBooks()
	{
		return list;
	}
	
	public BookEntity getBook(int id)  
	{
		BookEntity book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
		
		}
	
	
	public BookEntity addBook(BookEntity b)
	{
		 list.add(b);
		return b;
	}
	public void deletebook(int id)
	{
		list.removeIf(b->b.getId()==id);
	}
	
	public void updateBook(BookEntity book, int id)
	{
		list =list.stream().map(b->
		{
			if(b.getId()==id)
			{
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
			}return b;
		}
				).collect(Collectors.toList());
			
			
		}
	

}