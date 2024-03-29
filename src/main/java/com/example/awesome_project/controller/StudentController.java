package com.example.awesome_project.controller;

import com.example.awesome_project.model.Student;
import com.example.awesome_project.service.UtilService;
import io.swagger.v3.oas.annotations.Operation;
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

/*
@Operation - Описывает операцию или обычно метод HTTP для определенного пути.
@Parameter - Представляет один параметр в операции OpenAPI.
@RequestBody - Представляет тело запроса в операции
@ApiResponse - Представляет ответ в операции
@Tag - Представляет теги для операции или определения OpenAPI.
@Server - Представляет серверы для операции или для определения OpenAPI.
@Callback - Описывает набор запросов
@Link - Представляет возможную ссылку времени разработки для ответа.
@Schema - Позволяет определять входные и выходные данные.
@ArraySchema - Позволяет определять входные и выходные данные для типов массивов.
@Content - Предоставляет схему и примеры для определенного типа мультимедиа.
@Hidden - Скрывает ресурс, операцию или свойство
 */

@RestController
@RequestMapping("/students")
public class StudentController {

    //test
    private final UtilService utilService;

    @Autowired
    public StudentController(UtilService utilService) {
        this.utilService = utilService;
    }

    @Operation(description = "Just test")
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

    @GetMapping(params = {"student_name"})
    public List<Student> getStudentsByName(
            @RequestParam(name = "student_name")
                    String studentName) {
        return this.utilService.getStudentsByName(studentName);
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
