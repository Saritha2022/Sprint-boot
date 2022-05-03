
package com.example.BookNCharacter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookNCharacter.Entity.Book;
import com.example.BookNCharacter.Service.BookService;


@RestController
public class BookCharacterController{
	@Autowired
	BookService bookService;
		
	@GetMapping("/hello")
	public String getHi() {
		return "Book Character Control";
	}
	
	@GetMapping("/book")
	public  List<Book>  getBooks() {
		return bookService.getBooks();
		
	}
	@GetMapping("/book/{id}")
	public  Book getBookById(@PathVariable String id) {
		return bookService.getBookById(id);
	}
		@PostMapping("/book")
		public void addBook( @RequestBody Book book) {
			bookService.addBook(book);
		}

	@PutMapping("/book/{id}")
	public void updateBookById(@PathVariable String id, @RequestBody Book book) {
		bookService.updateBookById(id,book);
	}
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
	
	
}
