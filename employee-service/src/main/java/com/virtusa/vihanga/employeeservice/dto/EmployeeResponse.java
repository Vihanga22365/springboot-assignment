package com.virtusa.vihanga.employeeservice.dto;

import com.virtusa.vihanga.employeeservice.utill.EmployeeType;
import com.virtusa.vihanga.employeeservice.utill.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private String employeeId;
    private String name;
    private String department;
    private String phoneNo;
    private String address;
    private GenderType gender;
    private EmployeeType employeeType;
}
