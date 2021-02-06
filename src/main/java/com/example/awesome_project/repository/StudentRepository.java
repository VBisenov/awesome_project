package com.example.awesome_project.repository;

import com.example.awesome_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true,
    value = "SELECT student.full_name FROM student\n" +
            "INNER JOIN attendance_students ON attendance_students.students_student_id = student.student_id\n" +
            "INNER JOIN lesson ON lesson.attendance_id = attendance_students.attendance_attendance_id\n" +
            "WHERE lesson.lesson_id = ?1")
    public List<String> getStudentsThatAttendedLesson(Long lessonId);
}
