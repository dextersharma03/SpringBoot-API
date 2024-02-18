package com.example.restservice.dao;

import com.example.restservice.model.Book;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Optional<Book> findById(int id);
    List<Book> findAll();
    long count();
    Book create(Book book);
    Book update(Book book, int id);
    void delete(int id);

    void parse() throws IOException;
}
