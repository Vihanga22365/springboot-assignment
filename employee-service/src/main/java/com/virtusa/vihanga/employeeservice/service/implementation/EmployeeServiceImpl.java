package com.virtusa.vihanga.employeeservice.service.implementation;

import com.virtusa.vihanga.employeeservice.dto.DepartmentResponse;
import com.virtusa.vihanga.employeeservice.dto.EmployeeResponse;
import com.virtusa.vihanga.employeeservice.dto.EmployeeSalaryResponse;
import com.virtusa.vihanga.employeeservice.model.Employee;
import com.virtusa.vihanga.employeeservice.repository.EmployeeRepository;
import com.virtusa.vihanga.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    @Lazy
    private WebClient.Builder builder;

    @Override
    public EmployeeResponse createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .employeeId(savedEmployee.getEmployeeId())
                .name(savedEmployee.getName())
                .department(savedEmployee.getDepartment())
                .phoneNo(savedEmployee.getPhoneNo())
                .address(savedEmployee.getAddress())
                .gender(savedEmployee.getGender())
                .employeeType(savedEmployee.getEmployeeType())
                .build();

        return employeeResponse;
    }

    @Override
    public EmployeeResponse getEmployee(String employeeId) {
        Optional<Employee> fetchEmployee = employeeRepository.findById(employeeId);

        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .employeeId(fetchEmployee.get().getEmployeeId())
                .name(fetchEmployee.get().getName())
                .department(fetchEmployee.get().getDepartment())
                .phoneNo(fetchEmployee.get().getPhoneNo())
                .address(fetchEmployee.get().getAddress())
                .gender(fetchEmployee.get().getGender())
                .employeeType(fetchEmployee.get().getEmployeeType())
                .build();

        return employeeResponse;
    }

    @Override
    public EmployeeSalaryResponse getEmployeeSalary(String employeeId) {
        EmployeeResponse employeeResponse = getEmployee(employeeId);
        String departmentId = employeeResponse.getDepartment();

        DepartmentResponse departmentResponse = builder.build().get()
                .uri("http://department-service/api/v1/department/{id}", departmentId)
                .retrieve()
                .bodyToMono(DepartmentResponse.class)
                .block();

        EmployeeSalaryResponse employeeSalaryResponse = EmployeeSalaryResponse.builder()
                .employeeId(employeeResponse.getEmployeeId())
                .name(employeeResponse.getName())
                .departmentName(departmentResponse.getDepartmentName())
                .salary(departmentResponse.getSalary())
                .build();

        return employeeSalaryResponse;
    }

    @Override
    public void uploadEmployee(MultipartFile multipartFile) throws IOException {
        log.info("inside upload Employee - Service");
        if (ExcelUploadImpl.isValidExcelFile(multipartFile)) {
            log.info("inside upload Employee - In Service");
            List<Employee> employees = ExcelUploadImpl.getEmployeeDataFromExcel(multipartFile);
            employeeRepository.saveAll(employees);
        }
    }
}
