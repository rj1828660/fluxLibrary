package com.example.fluxLibrary.models;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Document(collection = "books")

public class Book {
    @Id
    @NotNull(message = "id is required")
    private String id;
    @NotBlank(message = "Title is required")
    private String title;
    @Positive(message = "Copies available must be positive")
    @NotNull(message = "Copies available is required")


    private int copiesAvailable;
    private String authorId;
    private String genre;

    public  Book(String id,String title,int copiesAvailable,String authorId,String genre){
        this.id=id;
        this.title=title;
        this.copiesAvailable=copiesAvailable;
        this.authorId=authorId;
        this.genre=genre;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
// Getters and setters
}

