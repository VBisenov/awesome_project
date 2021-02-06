package com.example.awesome_project.repository;

import com.example.awesome_project.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
