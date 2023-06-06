package com.virtusa.vihanga.departmentservice.service.implementation;

import com.virtusa.vihanga.departmentservice.dto.DepartmentResponse;
import com.virtusa.vihanga.departmentservice.model.Department;
import com.virtusa.vihanga.departmentservice.repository.DepartmentRepository;
import com.virtusa.vihanga.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponse departmentResponse = DepartmentResponse.builder().
                departmentId(savedDepartment.getDepartmentId()).
                departmentName(savedDepartment.getDepartmentName()).
                salary(savedDepartment.getSalary()).build();

        return departmentResponse;
    }
    @Override
    public DepartmentResponse getDepartment(String departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(department.isPresent()) {
            return DepartmentResponse.builder().
                    departmentId(department.get().getDepartmentId()).
                    departmentName(department.get().getDepartmentName()).
                    salary(department.get().getSalary()).build();
        } else {
            return null;
        }
    }


}
