package com.example.awesome_project.repository;

import com.example.awesome_project.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(nativeQuery = true,
    value = "SELECT * FROM lesson l " +
            "INNER JOIN discipline d ON d.discipline_id = l.discipline_id " +
            "WHERE d.name = ?1 AND l.date_time = ?2")
    public Lesson getLessonByDisciplineNameAndDate(String name, long dateTime);
}
