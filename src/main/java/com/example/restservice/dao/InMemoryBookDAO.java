package com.example.restservice.dao;

import com.example.restservice.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//this is for dependency injections, so that we don't have to create a new instance of this class everytime in BookController
@Repository
public class InMemoryBookDAO implements BookDAO{
    private List<Book> books = new ArrayList<>();

    public InMemoryBookDAO() {
        loadBooks();
    }

    private void loadBooks() {
        books.add(new Book(1, "Dexter's CRUD REst API", "Dexter", "Amazon"));
        books.add(new Book(2, "Test Book", "John Snow", "Amazon"));
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public long count() {
        return books.toArray().length;
    }

    @Override
    public Book create(Book book) {
        //we don't have to pass id when we create a new book, as this will be handled below automatically
        book.setId((int)count()+1);
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book, int id) {
        book.setId(id);
        books.set(id-1,book);
        return book;
    }

    @Override
    public void delete(int id) {
        books.remove(id-1);
    }
}
