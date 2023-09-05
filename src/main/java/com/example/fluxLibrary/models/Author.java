package com.example.fluxLibrary.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "authors")

public class Author {
    @Id
    @NotNull(message = "id is required")
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    private Address address;

    public Author(String id,String name,Address address){
        this.id=id;
        this.name=name;
        this.address=address;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
// Getters and setters
}


