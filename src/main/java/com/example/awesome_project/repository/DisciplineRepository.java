package com.example.awesome_project.repository;

import com.example.awesome_project.model.Discipline;
import com.example.awesome_project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    @Query(nativeQuery = true,
    value = "SELECT * FROM discipline d " +
            "INNER JOIN lesson l ON l.discipline_id = d.discipline_id " +
            "WHERE l.teacher_id =" +
            "(" +
            "SELECT t.teacher_id FROM teacher t " +
            "WHERE t.full_name = ?1 " +
            ")")
    public List<Discipline> getDisciplineByTeacher(String teacherName);
}
