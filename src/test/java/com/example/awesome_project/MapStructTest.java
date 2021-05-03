package com.example.awesome_project;

import com.example.awesome_project.model.Student;
import com.example.awesome_project.model.StudentDTO;
import com.example.awesome_project.config.StudentDTOMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapStructTest {

    StudentDTOMapper mapper = Mappers.getMapper(StudentDTOMapper.class);

    @Test
    void StudentToStudentDTOMappingTest() {
        Student student = new Student();
        student.setFullName("Henry");
        student.setId(UUID.randomUUID());

        StudentDTO studentDTO = mapper.studentToStudentDTO(student);
        assertEquals(studentDTO.getName(), student.getFullName());
        assertEquals(studentDTO.getId(), student.getId());
    }

    @Test
    void StudentDTOToStudentMappingTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("Henry");
        studentDTO.setId(UUID.randomUUID());

        Student student = mapper.studentDTOToStudent(studentDTO);
        assertEquals(studentDTO.getName(), student.getFullName());
        assertEquals(studentDTO.getId(), student.getId());
    }
}
