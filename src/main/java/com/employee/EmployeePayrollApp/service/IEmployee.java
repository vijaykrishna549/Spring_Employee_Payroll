package com.employee.EmployeePayrollApp.service;

import com.employee.EmployeePayrollApp.entity.Employee;

import java.util.List;

public interface IEmployee {

    Employee createEmployeeData(Employee employee);

    List<Employee> getAllEmployeeData();

    Employee getEmployeePayrollDataById(int empId);

    void deleteEmployeePayrollData(int empId);

//    Employee getAllEmployeeData();
}
