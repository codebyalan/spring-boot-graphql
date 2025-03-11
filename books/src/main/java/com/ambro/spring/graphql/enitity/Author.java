package com.ambro.spring.graphql.enitity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Author (String id, String name) {
    static List<Author> authors;
    static {
        authors = new ArrayList<>();
        authors.addAll(Arrays.asList(
                new Author("1", "John"),
                new Author("2", "Jane")
        ));
    }
    public static List<Author> getAllAuthors() {
        return authors;
    }
    public static Author getAuthorById(String id) {
        return authors.stream().filter(a -> a.id().equals(id)).findFirst().orElse(null);
    }
    public static Author addAuthor(Author author) {
        authors.add(author);
        return author;
    }

}
