package com.ambro.spring.graphql.service;

import com.ambro.spring.graphql.dto.AuthorRecord;
import com.ambro.spring.graphql.entity.Author;
import com.ambro.spring.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + id));
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author addAuthor(AuthorRecord authorRecord){
        Author newAuthor = new Author();
        newAuthor.setName(authorRecord.name());
        newAuthor.setNationality(authorRecord.nationality());
        return authorRepository.save(newAuthor);
    }

}
