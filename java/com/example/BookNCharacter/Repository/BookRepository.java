package com.example.BookNCharacter.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.BookNCharacter.Entity.Book;

public interface BookRepository extends CrudRepository<Book,String> {
	//public List<BookDemo> findAll();
}
