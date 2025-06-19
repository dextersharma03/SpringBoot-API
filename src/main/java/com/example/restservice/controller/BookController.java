package com.example.restservice.controller;

import com.example.restservice.dao.BookDAO;
import com.example.restservice.model.Book;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//this tells our class that it will accept http request
@RestController
@RequestMapping("/api/books")
public class BookController {

    /* This should be handled in a seperate class, just to keep controller files clean. Since controllers are mostly to take and respond to requests.
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books = Arrays.asList(
                new Book(1, "Dexter's CRUD REst API", "Dexter", "Amazon"),
                new Book(2, "Test Book", "John Snow", "Amazon")
        );
    }*/


    private final BookDAO dao;

    public BookController(BookDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return dao.findAll();
    }

    @GetMapping("/{id}")  // api/books/1
    public Book findById(@PathVariable Integer id){
        Optional<Book> book = dao.findById(id);
        if(book.isPresent()) return book.get();  //isPresent is a method from Optional class
        else throw new RuntimeException("Book with id "+id+" was not found");
    }

    @PostMapping //post-mapping
    public void create(@RequestBody Book book){
        dao.create(book);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Book book, @PathVariable Integer id){
        //update an existing book
        dao.update(book,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        //delete by id
        dao.delete(id);
    }

    //more endpoints
    public void findBookByAuthor(){

    }
}


