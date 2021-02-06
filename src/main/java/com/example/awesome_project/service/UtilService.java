package com.example.awesome_project.service;

import com.example.awesome_project.repository.LessonRepository;
import com.example.awesome_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtilService {
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    @Autowired
    public UtilService(StudentRepository studentRepository,
                       LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    public List<String> getStudentsThatAttendedLesson(String lessonName, long dateTime) {
        System.out.println("LOG: Resolving lesson ID...");
        long id = lessonRepository.getLessonIdByDisciplineNameAndDate(lessonName, dateTime);
        System.out.println("LOG: Lesson ID resolved: " + id + ". Resolving students...");
        return studentRepository.getStudentsThatAttendedLesson(id);
    }
}
