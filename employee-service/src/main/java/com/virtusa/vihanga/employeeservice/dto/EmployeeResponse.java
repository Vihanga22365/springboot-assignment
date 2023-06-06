package com.virtusa.vihanga.employeeservice.dto;

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
    private String gender;
    private String employeeType;
}
