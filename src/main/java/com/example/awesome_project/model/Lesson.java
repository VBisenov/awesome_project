package com.example.awesome_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Lesson {
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private Discipline discipline;
    private Long dateTime;
    @OneToOne
    @JoinColumn(name = "attendance_id", referencedColumnName = "attendance_id")
    private Attendance attendance;
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    public Lesson(Discipline discipline, Long dateTime, Attendance attendance, Teacher teacher) {
        this.discipline = discipline;
        this.dateTime = dateTime;
        this.attendance = attendance;
        this.teacher = teacher;
    }

    public Lesson() {
    }
}
