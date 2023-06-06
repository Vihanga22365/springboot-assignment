package com.virtusa.vihanga.departmentservice.controller;

import com.virtusa.vihanga.departmentservice.dto.DepartmentResponse;
import com.virtusa.vihanga.departmentservice.model.Department;
import com.virtusa.vihanga.departmentservice.service.DepartmentService;
import com.virtusa.vihanga.departmentservice.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("department")
    public ResponseEntity<StandardResponse> createDepartment(@RequestBody Department department) {
        DepartmentResponse departmentResponse = departmentService.createDepartment(department);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Department Created Successfully", departmentResponse), HttpStatus.CREATED
        );


    }

    @GetMapping("department/{id}")
    public DepartmentResponse getDepartment(@PathVariable("id") String departmentId) {
        return departmentService.getDepartment(departmentId);
    }
}
