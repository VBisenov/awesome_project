package com.example.awesome_project.controller;

import com.example.awesome_project.model.Student;
import com.example.awesome_project.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final UtilService utilService;

    @Autowired
    public StudentController(UtilService utilService) {
        this.utilService = utilService;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "HELLO WORLD";
    }

    @GetMapping(params = {"discipline_name", "date_time"})
    public List<Student> getStudentsThatAttendsLessonByDisciplineName(
            @RequestParam(name = "discipline_name")
                    String disciplineName,
            @RequestParam(name = "date_time")
                    long dateTime) {
        return this.utilService.getStudentsThatAttendedLesson(disciplineName, dateTime);
    }


    @GetMapping(params = "faculty_name")
    public List<Student> getStudentsByFacultyName(
            @RequestParam(name = "faculty_name")
                    String facultyName) {
        return this.utilService.getStudentsByFacultyName(facultyName);
    }


    @GetMapping(value = "/quantity", params = "faculty_name")
    public long getStudentsNumByFacultyName(
            @RequestParam(name = "faculty_name")
                    String facultyName) {
        return this.utilService.getStudentsNumByFacultyName(facultyName);
    }

    @GetMapping(value = "/quantity")
    public long getStudentsNumByFacultyName() {
        return this.utilService.getStudentsNum();
    }
}
