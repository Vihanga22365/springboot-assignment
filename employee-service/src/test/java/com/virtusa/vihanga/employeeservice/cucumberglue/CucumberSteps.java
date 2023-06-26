package com.virtusa.vihanga.employeeservice.cucumberglue;

import com.virtusa.vihanga.employeeservice.model.Employee;
import com.virtusa.vihanga.employeeservice.utill.EmployeeType;
import com.virtusa.vihanga.employeeservice.utill.GenderType;
import com.virtusa.vihanga.employeeservice.utill.StandardResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CucumberSteps extends CucumberConfig {
    Employee employee;
    String URI;
    private ResponseEntity<StandardResponse> responseEntity;
    private String responseMessage;

    public String getMainUrl() {
        return mainUrl+8500+"/api/v1/";
    }

    @Given("the employee details request body")
    public void the_employee_details_request_body() {
        employee = Employee.builder()
                .employeeId("EMP006")
                .name("Naradha Nirmal")
                .department("DEP01")
                .phoneNo("0765478956")
                .address("No 70, Colombo")
                .employeeType(EmployeeType.CONTRACT_BASIS)
                .gender(GenderType.MALE)
                .build();
    }
    @When("a POST request is sent to {string}")
    public void a_post_request_is_sent_to(String string) {
        URI = getMainUrl() + string;
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {

        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        ResponseEntity<StandardResponse> postResponse = restTemplate.exchange(URI, HttpMethod.POST, entity, StandardResponse.class);
        assertEquals(Optional.of(expectedStatusCode), Optional.of(postResponse.getStatusCodeValue()));
    }
    @Then("the response body contains the employee details")
    public void the_response_body_contains_the_employee_details() {
        responseMessage = "Employee Created Successfully";

        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        ResponseEntity<StandardResponse> postResponse = restTemplate.exchange(URI, HttpMethod.POST, entity, StandardResponse.class);
        assertEquals(responseMessage, postResponse.getBody().getMessage());
    }
}
