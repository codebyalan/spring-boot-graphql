package com.ambro.spring.graphql.service;

import com.ambro.spring.graphql.entity.Author;
import com.ambro.spring.graphql.entity.Book;
import com.ambro.spring.graphql.entity.Publication;
import com.ambro.spring.graphql.repository.AuthorRepository;
import com.ambro.spring.graphql.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BookResolver  {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    public Set<Author> getAuthors(Book book) {
        return book.getAuthors();
    }

    public Publication getPublication(Book book) {
        return book.getPublication();
    }
}
