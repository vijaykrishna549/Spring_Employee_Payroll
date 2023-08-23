package com.employee.EmployeePayrollApp.controller;

import com.employee.EmployeePayrollApp.dao.Employeedao;
import com.employee.EmployeePayrollApp.entity.Employee;
import com.employee.EmployeePayrollApp.entity.ResponseDTO;
import com.employee.EmployeePayrollApp.repository.EmployeeRepo;
import com.employee.EmployeePayrollApp.service.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employedata")
public class EmployeeController {

    @Autowired
    EmployeeImpl employeeImpl;

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody Employee employee) {
        System.out.println("Received employee data: " + employee.toString()); // Debug log
        Employee employee1 = employeeImpl.createEmployeeData(employee);
        ResponseDTO responseDTO = new ResponseDTO("Created employee data successfully", employee1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployeeData() {
        try {
            List<Employee> employees = new ArrayList<>();
            employees = employeeImpl.getAllEmployeeData();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity <Employee>  getEmployeeById(@PathVariable Integer id){
        Optional<Employee> empData = employeeRepo.findById(id);
        if(empData.isPresent()){
            return  new ResponseEntity<>(empData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeeImpl.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Delete Id : " +empId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody Employeedao employeedao)
    {
        Employee empData = employeeImpl.updateEmployeePayrollData(empId,employeedao);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

}
