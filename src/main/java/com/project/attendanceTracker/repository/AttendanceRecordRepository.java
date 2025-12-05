package com.project.attendanceTracker.repository;

import com.project.attendanceTracker.model.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Integer> {
    @Query("Select a from AttendanceRecord a WHERE a.uniqueConstraint = ?1")
    AttendanceRecord checkTodaysCheckIn(String uniqueConstraint);

    @Query("Select a from AttendanceRecord a WHERE a.employee.id = ?1 AND a.punchInAt BETWEEN ?2 AND ?3")
    List<AttendanceRecord> getMyAttendanceRecords(int id, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
