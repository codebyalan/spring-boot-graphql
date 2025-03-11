package com.ambro.spring.graphql.controller;

import com.ambro.spring.graphql.enitity.Author;
import com.ambro.spring.graphql.enitity.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @QueryMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument String id) {
        return Book.getBookById(id);
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Author getAuthor(Book book) {
        return book.auther();
    }



}