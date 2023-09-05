package com.example.fluxLibrary.services;



import com.example.fluxLibrary.models.Book;
import com.example.fluxLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    //get all books
    public Flux<Book> getAllBooks(){

        return bookRepository.findAll();
    }
    //get books of give genre
    public Flux<Book> getBooksByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }
    //get all books of given genre and copies greater than input value
    public Flux<Book> getBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable){
        return bookRepository.findBooksByGenreAndCopiesAvailable(genre, copiesAvailable);
    }

    //get books by author name
    public Flux<Book> getBooksByAuthorId(String authorId){

        return bookRepository.findBookByAuthorId(authorId);
    }
    //create book
    public Mono<Book> createBook(Book book){
        return bookRepository.save(book);
    }




}
