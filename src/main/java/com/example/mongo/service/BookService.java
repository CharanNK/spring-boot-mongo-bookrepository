package com.example.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.mongo.model.Book;

import java.util.*;

@Service
public class BookService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Book> getAllBooks(){
		Query query = new Query().with(Sort.by(Sort.Direction.ASC,"id"));
		return mongoTemplate.find(query, Book.class);
	}
	
	public Book getBookById(int id){
		Query query = new Query().addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Book.class);
	}
}
