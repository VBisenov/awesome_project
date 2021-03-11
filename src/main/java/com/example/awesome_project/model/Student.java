package com.example.awesome_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private Faculty faculty;

    public Student(String fullName, Faculty faculty) {
        this.fullName = fullName;
        this.faculty = faculty;
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student() {
    }
}
