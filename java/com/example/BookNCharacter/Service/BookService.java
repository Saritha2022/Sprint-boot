package com.example.BookNCharacter.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookNCharacter.Entity.Book;
import com.example.BookNCharacter.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	public BookRepository bookRepository;
	
	public List<Book> getBooks() {
		List<Book> allBooks=new ArrayList<>();
		bookRepository.findAll().forEach(allBooks::add);
		System.out.println("getAll()"+allBooks);
				return allBooks;
	}

	public Book getBookById(String id) {
		System.out.println(bookRepository.findById(id).orElse(null));
				return bookRepository.findById(id).orElse(null);
	}
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}
	public void updateBookById(String id, Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
		
	}
	
}
