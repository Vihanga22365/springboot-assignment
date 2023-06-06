package com.virtusa.vihanga.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    private String employeeId;
    private String name;
    private String department;
    private String phoneNo;
    private String address;
    private String gender;
    private String employeeType;
}
