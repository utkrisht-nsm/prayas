package com.prayas.controller;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;
import java.time.Instant;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prayas.model.Book;
import com.prayas.repository.BookRepository;

@RestController
@RequestMapping(value = "/api/cassandra")
public class ApplicationController {

  @Autowired
  private BookRepository bookRepository;

  private Book javaBook = new Book(UUIDs.timeBased(), "Head First Java", "O'Reilly Media",
  ImmutableSet.of("Computer", "Software"));

  @GetMapping(value = "/ping")
  ResponseEntity<String> ping() {

    return new ResponseEntity<String>("UTC Timestamp :\t{" + Instant.now().toString() + "}\nMessage :\t{Pong}",
        HttpStatus.OK);

  }

  @GetMapping(value = "/save")
  public ResponseEntity<String> saveBook() {

    bookRepository.save(ImmutableSet.of(javaBook));
    return new ResponseEntity<String>("Saved", HttpStatus.OK);

  }

  @GetMapping(value = "/update")
  public ResponseEntity<String> updateBook() {

    javaBook.setTitle("Head First Java Second Edition");
    bookRepository.save(ImmutableSet.of(javaBook));
    return new ResponseEntity<String>("Updated", HttpStatus.OK);

  }

  @GetMapping(value = "/delete")
  public ResponseEntity<String> writeSomething() {

    bookRepository.delete(javaBook);
    return new ResponseEntity<String>("Deleted", HttpStatus.OK);

  }

  //TODO : Get All Books, Paginated :)
  @GetMapping(value = "/findall")
  public ResponseEntity<String> getAllBooks() {
    return new ResponseEntity<String>("WIP", HttpStatus.OK);
  }

}
