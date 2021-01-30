package com.example.awesome_project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Book {
    @Id
    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private Genre genre;

    public Book(String name, LocalDate releaseDate, Genre genre) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Book(String name, Genre genre) {
        this(name, LocalDate.now(), genre);
        this.name = name;
        this.genre = genre;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre=" + genre +
                '}';
    }
}
