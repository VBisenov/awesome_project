package com.example.awesome_project.controller;

import com.example.awesome_project.model.Discipline;
import com.example.awesome_project.model.Teacher;
import com.example.awesome_project.repository.DisciplineRepository;
import com.example.awesome_project.repository.TeacherRepository;
import com.example.awesome_project.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final UtilService utilService;

    @Autowired
    public DisciplineController(UtilService utilService) {
        this.utilService = utilService;
    }

    @GetMapping(params = "teacher_name")
    public List<Discipline> getDisciplineByTeacher (
            @RequestParam("teacher_name")
                    String teacherName) {
        return this.utilService.getDisciplineByTeacher(teacherName);
    }

    @GetMapping("/all")
    public List<String> getDisciplinesByTeachersMapping() {
        return this.utilService.getDisciplinesByTeachersMapping();
    }
}
