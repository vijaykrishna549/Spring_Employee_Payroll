package com.employee.EmployeePayrollApp.entity;

import com.employee.EmployeePayrollApp.dao.Employeedao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employeetb")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @Column(name ="department")
    private List<String> department;

    // Add a default constructor
    public Employee() {
    }

    // Add a copy constructor
    public Employee(Employee employee) {
        this.name = employee.getName();
        this.gender = employee.getGender();
        this.startDate = employee.getStartDate();
        this.note = employee.getNote();
        this.profilePic = employee.getProfilePic();
        this.department = employee.getDepartment();
    }

    public void updateEmployeePayrollData(Employeedao employeedao) {
        this.name = employeedao.name;
        this.gender = employeedao.gender;
        this.startDate = employeedao.startDate;
        this.note = employeedao.note;
        this.profilePic = employeedao.profilePic;
        this.department = employeedao.department;
    }
}
