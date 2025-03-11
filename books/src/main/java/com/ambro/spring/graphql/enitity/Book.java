package com.ambro.spring.graphql.enitity;

import java.util.Arrays;
import java.util.List;

public record Book (String id, String title, Author auther) {
    static List<Book> books;
    static {
        books = Arrays.asList(
                new Book("1", "The Hobbit", Author.getAuthorById("1")),
                new Book("2", "The Lord of the Rings", Author.getAuthorById("2"))
        );
    }
    public static List<Book> getAllBooks() {
        return books;
    }
    public static Book getBookById(String id) {
        return books.stream().filter(b -> b.id().equals(id)).findFirst().orElse(null);
    }

    public static Book addBook(Book book) {
        books.add(book);
        return book;
    }

}