package com.example.awesome_project.repository;

import com.example.awesome_project.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository; 

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
