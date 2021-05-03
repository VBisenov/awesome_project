package com.example.awesome_project.config;

import com.example.awesome_project.model.Faculty;
import com.example.awesome_project.model.Student;
import com.example.awesome_project.model.StudentDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class StudentDTOMapper {
    @BeforeMapping
    private void testBefore(Student student, @MappingTarget StudentDTO studentDTO) {
        System.out.println(Student.class.getName() + " converts to " + StudentDTO.class.getName());
    }

    @AfterMapping
    private void testAfter(StudentDTO studentDTO, @MappingTarget Student student) {
        System.out.println(StudentDTO.class.getName() + " converts to " + Student.class.getName());
    }

    @Mappings(
            @Mapping(
                    target = "name",
                    source = "fullName"
            )
    )
    public abstract StudentDTO studentToStudentDTO(Student student);

    public Student studentDTOToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFullName(studentDTO.getName());
        student.setId(studentDTO.getId());

        Faculty faculty = new Faculty("Some faculty");
        student.setFaculty(faculty);

        return student;
    }
}
