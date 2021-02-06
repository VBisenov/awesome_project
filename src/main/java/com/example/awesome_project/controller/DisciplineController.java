package com.example.awesome_project.controller;

import com.example.awesome_project.model.Discipline;
import com.example.awesome_project.model.Teacher;
import com.example.awesome_project.repository.DisciplineRepository;
import com.example.awesome_project.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineController(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping(params = "teacher_name")
    public List<Discipline> getDisciplineByTeacher (
            @RequestParam("teacher_name")
                    String teacherName) {
        System.out.println("LOG: Get discipline by teacher " + teacherName);
        return this.disciplineRepository.getDisciplineByTeacher(teacherName);
    }
}
