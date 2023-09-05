package com.example.fluxLibrary.services;



import com.example.fluxLibrary.models.Author;
import com.example.fluxLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AuthorService {



    @Autowired
    public AuthorRepository authorRepository;
    public Mono<Author> findAuthorByName(String name){
        return authorRepository.findByName(name);

    }
    public Flux<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Mono<Author> createAuthor(Author author){
        return authorRepository.save(author);
    }
    public Flux<Author> getAuthorsByNameRegex(String nameRegex){
        return authorRepository.findByAuthorNameRegex(nameRegex);
    }
}
