package com.example.awesome_project.controller;

import com.example.awesome_project.model.Lesson;
import com.example.awesome_project.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final UtilService utilService;

    @Autowired
    public LessonController(UtilService utilService) {
        this.utilService = utilService;
    }

    @GetMapping(params = {"discipline_name", "date_time"})
    public Lesson getLessonByDisciplineNameAndDate(
            @RequestParam(name = "discipline_name")
                    String disciplineName,
            @RequestParam(name = "date_time")
                    long dateTime) {
        return this.utilService.getLessonByDisciplineNameAndDate(disciplineName, dateTime);
    }

    @GetMapping()
    public List<String> getLessonsPerTeacher() {
        return this.utilService.getLessonsPerTeacher();
    }

    @GetMapping(params = "teacher_id")
    public List<String> getLessonsPerTeacher(
            @RequestParam(name = "teacher_id")
                    long teacherId) {
        return this.utilService.getLessonsByTeacher(teacherId);
    }
}
