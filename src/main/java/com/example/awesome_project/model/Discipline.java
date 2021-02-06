package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Discipline {
    @Id
    @Column(name = "discipline_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;

    public Discipline(String name) {
        this.name = name;
    }

    public Discipline() {
    }
}
