package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
