package com.project.attendanceTracker.repository;

import com.project.attendanceTracker.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    @Query("Select m from Manager m WHERE m.user.username = ?1")
    Manager getByUsername(String username);
}
