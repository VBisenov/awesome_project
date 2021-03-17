package com.example.awesome_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    private Discipline discipline;
    private Long dateTime;
    @OneToOne
    @JoinColumn(name = "attendance_id", referencedColumnName = "id")
    private Attendance attendance;
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
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
