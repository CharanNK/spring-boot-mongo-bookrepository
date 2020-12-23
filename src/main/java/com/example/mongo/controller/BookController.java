package com.example.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.model.Book;
import com.example.mongo.repository.BookRepository;
import com.example.mongo.service.BookService;
import com.sun.el.stream.Optional;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/addBook",method = RequestMethod.POST)
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Added book with id : ";
	}
	
	@RequestMapping(value="/findAllBooks", method = RequestMethod.GET)
	public List<Book> getBooks(){
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value = "/findAllBooks/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable int id){
		Book book = bookService.getBookById(id);
		if(book!=null)
			return new ResponseEntity<>(book,HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted with id"+id;
	}
}
