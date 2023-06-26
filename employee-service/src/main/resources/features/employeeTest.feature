Feature: Employee Management

  Scenario: Create Employee
    Given the employee details request body
    When a POST request is sent to "employee"
    Then the response status code should be 201
    And the response body contains the employee details

#  Scenario: Get Employee
#    Given an employee ID
#    When a GET request is sent to "/api/v1/employee/{id}"
#    Then the response status code should be 200
#    And the response body contains the employee details