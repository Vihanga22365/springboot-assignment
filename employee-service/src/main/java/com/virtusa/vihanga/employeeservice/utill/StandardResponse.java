package com.virtusa.vihanga.employeeservice.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
