package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Faculty {
    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty() {
    }
}
