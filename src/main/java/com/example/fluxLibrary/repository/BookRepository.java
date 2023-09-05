package com.example.fluxLibrary.repository;

import com.example.fluxLibrary.models.Book;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByGenre(String genre);
    @Query(value = "{'genre': ?0, 'copiesAvailable': {$gt: ?1}}")
    Flux<Book> findBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable);

    //    @Query(value = "{'id': ?0}")
    Flux<Book> findBookByAuthorId(String authorId);
}