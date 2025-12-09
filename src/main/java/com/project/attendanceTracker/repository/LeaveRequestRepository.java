package com.project.attendanceTracker.repository;

import com.project.attendanceTracker.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    @Query("Select l from LeaveRequest l WHERE l.uniqueIdentifier = ?1")
    LeaveRequest getLeaveRequestForWithdrawing(String s);
}
