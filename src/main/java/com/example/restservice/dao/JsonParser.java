package com.example.restservice.dao;

import com.example.restservice.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    public void parse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Book book = objectMapper.readValue(new File(".\\data\\info.json"),Book.class);

        System.out.println(book);

    }
}
