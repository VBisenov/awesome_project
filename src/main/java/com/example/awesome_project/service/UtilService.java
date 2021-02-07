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
        List<Student> result = studentRepository.getStudentsThatAttendedLesson(disciplineName, dateTime);
        System.out.println("LOG: Get students that attend lesson by discipline name result: " + result);
        return result;
    }

    public Lesson getLessonByDisciplineNameAndDate(String disciplineName, long dateTime) {
        System.out.println("LOG: Get lesson by discipline name: " + disciplineName +
                " for date " + Instant.ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime());
        Lesson result =  this.lessonRepository.getLessonByDisciplineNameAndDate(disciplineName, dateTime);
        System.out.println("LOG: Get lesson by discipline name: " + disciplineName +
                " for date " + Instant.ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime() +
                " result: " + result);
        return result;
    }

    public List<Student> getStudentsByFacultyName(String facultyName) {
        System.out.println("LOG : GET students by faculty name " + facultyName);
        List<Student> result = this.studentRepository.getStudentsByFacultyName(facultyName);
        System.out.println("LOG : GET students by faculty name result: " + result);
        return result;
    }

    public List<Student> getStudentsByName(String studentName) {
        System.out.println("LOG : GET students by name like " + studentName);
        List<Student> result = this.studentRepository.getStudentsByName(studentName);
        System.out.println("LOG : GOT students by name like " + studentName + " result : " + result);
        return result;
    }

    public long getStudentsNumByFacultyName(String facultyName) {
        System.out.println("LOG : GET students by faculty name " + facultyName);
        long result = this.studentRepository.getStudentsNumByFacultyName(facultyName);
        System.out.println("LOG : GET students by faculty name result: " + result);
        return result;
    }

    public long getStudentsNum() {
        System.out.println("LOG: GET students num in Hogwarts...");
        long result = this.studentRepository.getStudentsNum();
        System.out.println("LOG: GET students num in Hogwarts result: " + result);
        return result;
    }

    public List<Discipline> getDisciplineByTeacher(String teacherName) {
        System.out.println("LOG: Get discipline by teacher " + teacherName);
        List<Discipline> result = this.disciplineRepository.getDisciplineByTeacher(teacherName);
        System.out.println("LOG: Get discipline by teacher result: " + result);
        return result;
    }

    public List<String> getDisciplinesByTeachersMapping() {
        System.out.println("LOG: Get disciplines by teachers mapping...");
        List<String> result = this.disciplineRepository.getDisciplineByTeacherMap();
        System.out.println("LOG: Get disciplines by teachers mapping result: " + result);
        return result;
    }

    public List<String> getDisciplinesNumPerTeacher() {
        System.out.println("LOG: Get lessons number per teacher...");
        List<String> result = this.disciplineRepository.getLessonNumberPerTeacher();
        System.out.println("LOG: Get lessons number per teacher result: " + result);
        return result;
    }

    public List<String> getDisciplinesNumByTeacherName(String name) {
        System.out.println("LOG: Get disciplines num by teacher " + name);
        List<String> result = this.disciplineRepository.getDisciplinesNumByTeacherName(name);
        System.out.println("LOG: Get disciplines num per teacher result: " + result);
        return result;
    }

    public List<String> getDisciplinesNumByTeacherId(long id) {
        System.out.println("LOG: Get disciplines num by teacher with Id: " + id);
        List<String> result = this.disciplineRepository.getDisciplinesNumByTeacherId(id);
        System.out.println("LOG: Get disciplines num per teacher result: " + result);
        return result;
    }

    public List<String> getLessonsPerTeacher() {
        System.out.println("LOG: Get lessons per teacher");
        List<String> result = this.lessonRepository.getLessonPerTeacher();
        System.out.println("LOG: Get lessons number per teacher result: " + result);
        return result;
    }

    public List<String> getLessonsByTeacher(long teacherId) {
        System.out.println("LOG: Get lessons by teacher with Id: " + teacherId);
        List<String> result = this.lessonRepository.getLessonByTeacher(teacherId);
        System.out.println("LOG: Get lessons number per teacher result: " + result);
        return result;
    }
}
