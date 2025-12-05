package com.project.attendanceTracker.repository;

import com.project.attendanceTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
