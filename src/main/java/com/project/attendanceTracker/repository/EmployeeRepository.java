package com.project.attendanceTracker.repository;

import com.project.attendanceTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("Select e from Employee e WHERE e.user.username = ?1")
    Employee getByUsername(String name);
}
