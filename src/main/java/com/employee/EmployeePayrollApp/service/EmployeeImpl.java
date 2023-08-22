package com.employee.EmployeePayrollApp.service;


import com.employee.EmployeePayrollApp.entity.Employee;
import com.employee.EmployeePayrollApp.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeImpl implements IEmployee {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployeeData(Employee employee) {
        Employee empdata = new Employee(employee);
        log.debug("Emp data :" + empdata.toString()); // Debug log

        return employeeRepo.save(empdata);
    }

//    @Override
//    public Employee getAllEmployeeData(Employee employee) {
//        return null;
//    }

    @Override
    public List<Employee> getAllEmployeeData() {
  return (List<Employee>)
                employeeRepo.findAll();
    }

}
