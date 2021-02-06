package com.example.awesome_project.controller;

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

    @GetMapping(value = "/get-by-lesson")
    public String test() {
        return "HELLO WORLD";
    }

    @GetMapping(value = "/get-by-lesson", params = {"discipline_name"})
    public List<String> getStudentsThatAttendsLessonByDisciplineName(
            @RequestParam(name = "discipline_name")
                    String disciplineName) {
        System.out.println("LOG: Get students that attend lesson by lesson name: " + disciplineName);
        return new ArrayList<String>();
    }

    @GetMapping(value = "/get-by-lesson", params = {"discipline_name", "date_time"})
    public List<String> getStudentsThatAttendsLessonByDisciplineName(
            @RequestParam(name = "discipline_name")
                    String disciplineName,
            @RequestParam(name = "date_time")
                    long dateTime) {
        System.out.println("LOG: Get students that attend lesson by lesson name: " + disciplineName +
                " for date " + Instant.ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime());
        return this.utilService.getStudentsThatAttendedLesson(disciplineName, dateTime);
    }
}
