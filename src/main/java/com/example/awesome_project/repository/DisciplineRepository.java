package com.example.awesome_project.repository;

import com.example.awesome_project.model.Discipline;
import com.example.awesome_project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    @Query(nativeQuery = true,
    value = "SELECT * FROM discipline d " +
            "INNER JOIN lesson l ON l.discipline_id = d.discipline_id " +
            "WHERE l.teacher_id =" +
            "(" +
            "SELECT t.teacher_id FROM teacher t " +
            "WHERE t.full_name = ?1 " +
            ")")
    List<Discipline> getDisciplineByTeacher(String teacherName);

    @Query(nativeQuery = true,
    value = "SELECT d.name as discipline_name, t.full_name as teacher_name FROM lesson l " +
            "INNER JOIN discipline d ON d.discipline_id = l.discipline_id " +
            "INNER JOIN teacher t ON t.teacher_id = l.teacher_id ")
    List<String> getDisciplineByTeacherMap();


    @Query(nativeQuery = true,
    value = "SELECT COUNT(l.lesson_id), t.full_name FROM lesson l " +
            "INNER JOIN teacher t ON t.teacher_id = l.teacher_id " +
            "GROUP BY t.full_name")
    List<String> getLessonNumberPerTeacher();

    @Query(nativeQuery = true,
            value = "SELECT COUNT(l.lesson_id), t.full_name FROM lesson l " +
                    "INNER JOIN teacher t ON t.teacher_id = l.teacher_id " +
                    "WHERE t.full_name = ?1 " +
                    "GROUP BY t.full_name ")
    List<String> getDisciplinesNumByTeacherName(String teacherName);

    @Query(nativeQuery = true,
            value = "SELECT COUNT(l.lesson_id), t.full_name FROM lesson l " +
                    "INNER JOIN teacher t ON t.teacher_id = l.teacher_id " +
                    "WHERE t.teacher_id = ?1 " +
                    "GROUP BY t.full_name ")
    List<String> getDisciplinesNumByTeacherId(long id);
}
