package com.example.mongo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mongo.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void createRows() {
		bookRepository.deleteAll();
		bookRepository.save(new Book(12345, "MongoDb", "charan"));
		bookRepository.save(new Book(23457, "Java", "Shashank"));
		bookRepository.save(new Book(78922, "Networks", "Suresh"));
		
		bookRepository.findAll().forEach(System.out::println);
	}

}
