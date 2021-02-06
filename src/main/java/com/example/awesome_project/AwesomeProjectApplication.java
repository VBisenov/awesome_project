package com.example.awesome_project;

import com.example.awesome_project.repository.*;
import com.example.awesome_project.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class AwesomeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwesomeProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertTestData(FacultyRepository facultyRepository,
                                            StudentRepository studentRepository,
                                            TeacherRepository teacherRepository,
                                            DisciplineRepository disciplineRepository,
                                            AttendanceRepository attendanceRepository,
                                            LessonRepository lessonRepository) {
        return (args) -> {
            Faculty facultyGryffindor = new Faculty("Gryffindor");
            Faculty facultySlytherin = new Faculty("Slytherin");
            Faculty facultyHufflepuff = new Faculty("Hufflepuff");
            Faculty facultyRavenclaw = new Faculty("Ravenclaw");

            facultyRepository.save(facultyGryffindor);
            facultyRepository.save(facultySlytherin);
            facultyRepository.save(facultyHufflepuff);
            facultyRepository.save(facultyRavenclaw);


            Student studentHarryPotter = new Student("Harry Potter", facultyGryffindor);
            Student studentRonWeasley= new Student("Ronald Weasley", facultyGryffindor);
            Student studentHermioneGranger = new Student("Hermione Granger", facultyGryffindor);

            Student studentDracoMalfoy = new Student("Draco Malfoy", facultySlytherin);
            Student studentGregoryGoyle = new Student("Gregory Goyle", facultySlytherin);
            Student studentVincentCrabbe = new Student("Vincent Crabbe", facultySlytherin);

            Student studentHannahAbbot = new Student("Hannah Abbott", facultyHufflepuff);
            Student studentSusanBones = new Student("Susan Bones", facultyHufflepuff);
            Student studentJustinFinchFletchley = new Student("Justin Finch-Fletchley", facultyHufflepuff);

            Student studentTerryBoot = new Student("Terry Boot", facultyRavenclaw);
            Student studentMandyBrocklehurst = new Student("Mandy Brocklehurst", facultyRavenclaw);
            Student studentMichaelCorner = new Student("Michael Corner", facultyRavenclaw);

            studentRepository.save(studentHarryPotter);
            studentRepository.save(studentRonWeasley);
            studentRepository.save(studentHermioneGranger);
            studentRepository.save(studentDracoMalfoy);
            studentRepository.save(studentGregoryGoyle);
            studentRepository.save(studentVincentCrabbe);
            studentRepository.save(studentHannahAbbot);
            studentRepository.save(studentSusanBones);
            studentRepository.save(studentJustinFinchFletchley);
            studentRepository.save(studentTerryBoot);
            studentRepository.save(studentMandyBrocklehurst);
            studentRepository.save(studentMichaelCorner);

            Teacher teacherRolandaHooch = new Teacher("Rolanda Hooch");
            Teacher teacherRubeusHagrid = new Teacher("Rubeus Hagrid");
            Teacher teacherSeverusSnape = new Teacher("Severus Snape");

            teacherRepository.save(teacherRolandaHooch);
            teacherRepository.save(teacherRubeusHagrid);
            teacherRepository.save(teacherSeverusSnape);

            Discipline disciplineFlying = new Discipline("Flying");
            Discipline disciplineCareOfMagicalCreatures = new Discipline("Care of Magical Creatures");
            Discipline disciplineDefenseAgainstTheDarkArts = new Discipline("Defense Against the Dark Arts ");

            disciplineRepository.save(disciplineFlying);
            disciplineRepository.save(disciplineCareOfMagicalCreatures);
            disciplineRepository.save(disciplineDefenseAgainstTheDarkArts);

            Attendance attendanceFlying =
                    new Attendance(Arrays.asList(studentHarryPotter, studentRonWeasley, studentHermioneGranger,
                    studentDracoMalfoy, studentGregoryGoyle, studentVincentCrabbe));
            Attendance attendanceCareOfMagicalCreatures =
                    new Attendance(Arrays.asList(studentHannahAbbot, studentSusanBones, studentJustinFinchFletchley));
            Attendance attendanceDefenseAgainstTheDarkArts =
                    new Attendance(Arrays.asList(studentTerryBoot, studentMandyBrocklehurst, studentMichaelCorner));

            attendanceRepository.save(attendanceFlying);
            attendanceRepository.save(attendanceCareOfMagicalCreatures);
            attendanceRepository.save(attendanceDefenseAgainstTheDarkArts);

            Lesson lessonFlying =
                    new Lesson(disciplineFlying, System.currentTimeMillis(), attendanceFlying, teacherRolandaHooch);
            Lesson lessonCareOfMagicalCreatures =
                    new Lesson(disciplineCareOfMagicalCreatures, System.currentTimeMillis() + 86400000, attendanceCareOfMagicalCreatures,
                            teacherRubeusHagrid);
            Lesson lessonDefenseAgainstTheDarkArts =
                    new Lesson(disciplineDefenseAgainstTheDarkArts, System.currentTimeMillis() - 86400000, attendanceDefenseAgainstTheDarkArts,
                            teacherSeverusSnape);

            lessonRepository.save(lessonFlying);
            lessonRepository.save(lessonCareOfMagicalCreatures);
            lessonRepository.save(lessonDefenseAgainstTheDarkArts);
        };
    }

}
