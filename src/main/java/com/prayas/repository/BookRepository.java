package com.prayas.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.prayas.model.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book> {
  // TODO : Try Out Custom CQL Queries
}
