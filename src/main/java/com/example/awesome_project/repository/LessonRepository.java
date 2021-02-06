package com.example.awesome_project.repository;

import com.example.awesome_project.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(nativeQuery = true,
    value = "SELECT lesson_id FROM lesson \n" +
            "INNER JOIN discipline ON discipline.discipline_id = lesson.discipline_id\n" +
            "WHERE discipline.name = ?1 AND lesson.date_time = ?2")
    public long getLessonIdByDisciplineNameAndDate(String name, long date);
}
