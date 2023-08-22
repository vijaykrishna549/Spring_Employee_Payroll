package com.employee.EmployeePayrollApp.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Employeedao {

    public String name;
    public String gender;
//    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;

}
