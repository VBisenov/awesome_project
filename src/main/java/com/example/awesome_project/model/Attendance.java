package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Attendance {
    @Id
    @Column(name = "attendance_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    private List<Student> students;

    public Attendance(List<Student> students) {
        this.students = students;
    }

    public Attendance() {
    }
}
