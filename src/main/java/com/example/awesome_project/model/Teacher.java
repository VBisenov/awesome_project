package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher{
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;

    public Teacher(String fullName) {
        this.fullName = fullName;
    }

    public Teacher() {
    }
}
