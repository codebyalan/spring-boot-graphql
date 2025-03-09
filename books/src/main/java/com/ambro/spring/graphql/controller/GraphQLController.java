package com.ambro.spring.graphql.controller;

import com.ambro.spring.graphql.dto.AuthorRecord;
import com.ambro.spring.graphql.dto.BookRec;
import com.ambro.spring.graphql.dto.PublicationRec;
import com.ambro.spring.graphql.entity.Author;
import com.ambro.spring.graphql.entity.Book;
import com.ambro.spring.graphql.entity.Publication;
import com.ambro.spring.graphql.service.AuthorService;
import com.ambro.spring.graphql.service.BookService;
import com.ambro.spring.graphql.service.PublicationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublicationService publicationService;

    public GraphQLController(BookService bookService, AuthorService authorService, PublicationService publicationService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publicationService = publicationService;
    }

    @QueryMapping
    public Book getBookById(@Argument Long id){
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> getAllBooks(){
        return bookService.listAllBooks();
    }

    @QueryMapping
    public Book addBook(@Argument BookRec book){
        return bookService.addBook(book);
    }

    @QueryMapping
    public Author getAuthorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @QueryMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author addAuthor(@Argument AuthorRecord author){
        return authorService.addAuthor(author);
    }

    @QueryMapping
    public Publication getPubliationById(@Argument Long id){
        return publicationService.getPublicationById(id);
    }

    @QueryMapping
    public List<Publication> getPublications(){
        return publicationService.getAllPublication();
    }

    @QueryMapping
    public Publication addPublication(@Argument String name, @Argument String location){
        return publicationService.addPublication(new PublicationRec(name, location));
    }

}
