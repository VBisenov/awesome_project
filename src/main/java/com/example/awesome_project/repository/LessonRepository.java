package com.example.awesome_project.repository;

import com.example.awesome_project.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(nativeQuery = true,
    value = "SELECT * FROM lesson l " +
            "INNER JOIN discipline d ON d.discipline_id = l.discipline_id " +
            "WHERE d.name = ?1 AND l.date_time = ?2")
    Lesson getLessonByDisciplineNameAndDate(String name, long dateTime);

    @Query(nativeQuery = true,
    value = "SELECT l.date_time, d.name, t.full_name FROM lesson l " +
            "INNER JOIN discipline d ON d.discipline_id = l.discipline_id " +
            "RIGHT JOIN teacher t ON t.teacher_id = l.teacher_id")
    List<String> getLessonPerTeacher();

    @Query(nativeQuery = true,
            value = "SELECT l.date_time, d.name, t.full_name FROM lesson l " +
                    "INNER JOIN discipline d ON d.discipline_id = l.discipline_id " +
                    "RIGHT JOIN teacher t ON t.teacher_id = l.teacher_id " +
                    "WHERE t.teacher_id = ?1")
    List<String> getLessonByTeacher(long id);
}
