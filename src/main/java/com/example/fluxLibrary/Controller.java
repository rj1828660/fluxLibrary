package com.example.fluxLibrary;

import com.example.fluxLibrary.models.Author;
import com.example.fluxLibrary.models.Book;
import com.example.fluxLibrary.services.AuthorService;
import com.example.fluxLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api")

@Validated
public class Controller {


    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;


    @GetMapping("/getBooks")
    public Flux<Book> getAllBooks(){

        return  bookService.getAllBooks();
    }

    @GetMapping("/books/{genre}")
    public Flux<Book> getBooksByGenre(@PathVariable String genre) {

        return bookService.getBooksByGenre(genre);
    }
    @GetMapping("/books/byGenreAndCopies/")
    public Flux<Book> getBooksByGenreAndCopiesAvailable(
            @RequestParam String genre,
            @RequestParam int copiesAvailable) {
        return bookService.getBooksByGenreAndCopiesAvailable(genre,copiesAvailable);

    }
    @GetMapping("/books/byAuthorName")
    public Flux<Book> getBooksByAuthorName(
            @RequestParam String name) {
    return authorService.findAuthorByName(name).flatMapMany(author -> bookService.getBooksByAuthorId(author.getId()));

    }

    @PostMapping("/books/createBook")
    public Mono<Book> createBook( @RequestBody Book book) {

        return bookService.createBook(book);

    }

    @GetMapping("/getAuthors")
    public Flux<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/createAuthors")
    public Mono<Author> createAuthor(@RequestBody Author author) {

        return  authorService.createAuthor(author);

    }
    @GetMapping("/authorsByName")
    public Flux<Author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return  authorService.getAuthorsByNameRegex(nameRegex);

    }



}
