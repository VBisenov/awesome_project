package com.example.awesome_project.controller;

import com.example.awesome_project.model.Lesson;
import com.example.awesome_project.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private UtilService utilService;

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
}
