package com.example.restservice.dao;

import com.example.restservice.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//this is for dependency injections, so that we don't have to create a new instance of this class everytime in BookController
@Repository
public class InMemoryBookDAO implements BookDAO {
    private List<Book> books = new ArrayList<>();

    public InMemoryBookDAO() throws IOException {
        parse();
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

    @Override
    public void parse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<?, ?> map = objectMapper.readValue(new File("C:\\Users\\diksh\\Desktop\\GIT\\SpringbootAPI\\SpringBoot-API\\src\\main\\java\\com\\example\\restservice\\data\\info.json"),Map.class);

        ArrayList arrayList = new ArrayList();

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            arrayList.add(entry.getValue());
        }

        books.add(new Book((int)arrayList.get(0),(String) arrayList.get(1),(String)arrayList.get(2),(String)arrayList.get(3)));
    }
}
