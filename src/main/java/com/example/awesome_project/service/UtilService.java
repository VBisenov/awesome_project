package com.example.awesome_project.service;

import com.example.awesome_project.model.Discipline;
import com.example.awesome_project.model.Lesson;
import com.example.awesome_project.model.Student;
import com.example.awesome_project.repository.DisciplineRepository;
import com.example.awesome_project.repository.LessonRepository;
import com.example.awesome_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Service
public class UtilService {
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public UtilService(StudentRepository studentRepository,
                       LessonRepository lessonRepository,
                       DisciplineRepository disciplineRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Student> getStudentsThatAttendedLesson(String disciplineName, long dateTime) {
        System.out.println("LOG: Get students that attend lesson by discipline name: " + disciplineName +
                " for date " + Instant.ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime());
        return studentRepository.getStudentsThatAttendedLesson(disciplineName, dateTime);
    }

    public Lesson getLessonByDisciplineNameAndDate(String disciplineName, long dateTime) {
        System.out.println("LOG: Get lesson by discipline name: " + disciplineName +
                " for date " + Instant.ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime());
        return this.lessonRepository.getLessonByDisciplineNameAndDate(disciplineName, dateTime);
    }

    public List<Student> getStudentsByFacultyName(String facultyName) {
        System.out.println("LOG : GET students by faculty name " + facultyName);
        return this.studentRepository.getStudentsByFacultyName(facultyName);
    }

    public long getStudentsNumByFacultyName(String facultyName) {
        System.out.println("LOG : GET students by faculty name " + facultyName);
        return this.studentRepository.getStudentsNumByFacultyName(facultyName);
    }

    public long getStudentsNum() {
        System.out.println("LOG: GET students num in Hogwarts...");
        return this.studentRepository.getStudentsNum();
    }

    public List<Discipline> getDisciplineByTeacher(String teacherName) {
        System.out.println("LOG: Get discipline by teacher " + teacherName);
        return this.disciplineRepository.getDisciplineByTeacher(teacherName);
    }
}
