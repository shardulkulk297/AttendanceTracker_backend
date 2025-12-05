package com.project.attendanceTracker.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance_record")
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Employee employee;

    private LocalDate recordDate;
    private LocalDateTime punchInAt;
    private LocalDateTime punchOutAt;
    private String status;
    private String uniqueConstraint;

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getUniqueConstraint() {
        return uniqueConstraint;
    }

    public void setUniqueConstraint(String uniqueConstraint) {
        this.uniqueConstraint = uniqueConstraint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getPunchInAt() {
        return punchInAt;
    }

    public void setPunchInAt(LocalDateTime punchInAt) {
        this.punchInAt = punchInAt;
    }

    public LocalDateTime getPunchOutAt() {
        return punchOutAt;
    }

    public void setPunchOutAt(LocalDateTime punchOutAt) {
        this.punchOutAt = punchOutAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
