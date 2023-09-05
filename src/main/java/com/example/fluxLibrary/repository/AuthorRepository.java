package com.example.fluxLibrary.repository;

import com.example.fluxLibrary.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AuthorRepository extends ReactiveMongoRepository<Author,String> {
    @Query("{'name': {$regex: ?0}}")
    Flux<Author> findByAuthorNameRegex(String nameRegex);
    @Query("{'name':?0}")
    Mono<Author> findByName(String name);
}