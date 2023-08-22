package com.employee.EmployeePayrollApp.service;

import com.employee.EmployeePayrollApp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployee {

    Employee createEmployeeData(Employee employee);

    List<Employee> getAllEmployeeData();

    Optional<Employee> getEmployeePayrollDataById(int empId);

//    Employee getAllEmployeeData();
}
