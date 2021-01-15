#Author: karthick.chitty@photoninfotech.net
#Keywords Summary : This feature file is used for represting a sample scenario 

@APITest
Feature: Accessing / Adding and Edit Employee details 
  I want to use this feature file to write sceanrios for all Employee related Endpoint

  @employees
  Scenario: Verify Employee Endpoint returns all employee details
    Given I have employee base URI
    When I perfrom a "GET" method on endpoint "/api/v1/employees"
    Then I should be able to get response for 24 employee details

    
  @employeName
  Scenario: Verify Employee Endpoint returns all employee details
    Given I have employee base URI
    When I perfrom a "GET" method on endpoint "/api/v1/employee/1"
    Then I should be able to get response for 1 employee
    Then I should be able to verify employee name "Tiger Nixon"
    