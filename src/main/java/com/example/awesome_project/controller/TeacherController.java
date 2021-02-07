package com.example.awesome_project.controller;

import com.example.awesome_project.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final UtilService utilService;

    @Autowired
    public TeacherController(UtilService utilService) {
        this.utilService = utilService;
    }

    @GetMapping("/discipline-num-per-teacher")
    public List<String> getDisciplinesNumPerTeacher() {
        return utilService.getDisciplinesNumPerTeacher();
    }

    @GetMapping(value = "/discipline-num-by-teacher", params = "full_name")
    public List<String> getDisciplinesNumPerTeacher(
            @RequestParam("full_name")
                    String fullName) {
        return utilService.getDisciplinesNumByTeacherName(fullName);
    }

    @GetMapping(value = "/discipline-num-by-teacher", params = "id")
    public List<String> getDisciplinesNumPerTeacher(
            @RequestParam("id")
                    long id) {
        return utilService.getDisciplinesNumByTeacherId(id);
    }
}
