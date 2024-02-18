package com.example.restservice.model;

import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    @NotEmpty(message = "Please check the data again!")  //check to see if user is not passing bad args or null values to create data
    private String title;
    private String author;
    private String publisher;

    public Book() {
        id = 0;
        title = null;
        this.author = null;
        this.publisher = null;
    }

    public Book(int id, String title, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

