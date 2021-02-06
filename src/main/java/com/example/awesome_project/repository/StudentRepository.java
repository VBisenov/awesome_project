package com.example.awesome_project.repository;

import com.example.awesome_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM student s " +
            "INNER JOIN attendance_students a_s ON a_s.students_student_id = s.student_id " +
            "INNER JOIN lesson l ON l.attendance_id = a_s.attendance_attendance_id " +
            "WHERE l.date_time = ?2 " +
            "AND l.discipline_id = " +
            "(" +
            "SELECT d.discipline_id FROM discipline d " +
            "WHERE d.name = ?1 " +
            ")")
    public List<Student> getStudentsThatAttendedLesson(String disciplineName, long dateTime);

    @Query(nativeQuery = true,
            value = "SELECT * FROM student s " +
                    "WHERE s.faculty_id = " +
                    "(" +
                    "SELECT f.faculty_id FROM faculty f " +
                    "WHERE f.name = ?1" +
                    ") ")
    public List<Student> getStudentsByFacultyName(String facultyName);

    @Query(nativeQuery = true,
    value = "SELECT COUNT(*) FROM student s " +
            "WHERE s.faculty_id = " +
            "(" +
            "SELECT f.faculty_id FROM faculty f " +
            "WHERE f.name = ?1" +
            ") ")
    public long getStudentsNumByFacultyName(String facultyName);

    @Query(nativeQuery = true,
    value = "SELECT COUNT(*) FROM student")
    public long getStudentsNum();
}
