package com.virtusa.vihanga.employeeservice.service;

import com.virtusa.vihanga.employeeservice.dto.EmployeeResponse;
import com.virtusa.vihanga.employeeservice.dto.EmployeeSalaryResponse;
import com.virtusa.vihanga.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    EmployeeResponse createEmployee(Employee employee);

    EmployeeResponse getEmployee(String employeeId);

    EmployeeSalaryResponse getEmployeeSalary(String employeeId);
}
