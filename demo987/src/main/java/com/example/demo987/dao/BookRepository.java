package com.example.demo987.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo987.entities.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer> 
{
	public BookEntity findById(int id);
	

}
