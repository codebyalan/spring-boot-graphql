package com.ambro.spring.graphql.service;

import com.ambro.spring.graphql.dto.BookRec;
import com.ambro.spring.graphql.entity.Author;
import com.ambro.spring.graphql.entity.Book;
import com.ambro.spring.graphql.entity.Publication;
import com.ambro.spring.graphql.repository.AuthorRepository;
import com.ambro.spring.graphql.repository.BookRepository;
import com.ambro.spring.graphql.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublicationRepository publicationRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublicationRepository publicationRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publicationRepository = publicationRepository;
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + id));
    }


    public Book addBook(BookRec bookRecord) {
        // Fetch author and publication references
        Set<Author> authors = bookRecord.authorIds().stream()
                .map(authorId -> authorRepository.findById(authorId)
                        .orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + authorId)))
                .collect(Collectors.toSet());

        Publication publication = publicationRepository.findById(bookRecord.publicationId())
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with ID: " + bookRecord.publicationId()));

        // Create new book entity
        Book newBook = new Book();
        newBook.setTitle(bookRecord.title());
        newBook.setAuthors(authors);
        newBook.setPublication(publication);
        newBook.setPublishedYear(bookRecord.publishedYear());
        newBook.setIsbn(bookRecord.isbn());

        return bookRepository.save(newBook);
    }
}


