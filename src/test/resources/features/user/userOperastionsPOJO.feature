@PutandUpdatePOJO
Feature: Create new user

  Background:
    Given the application is configured to connect to base url

  Scenario: Generate a new user using POJO class
    When The admin generate a new user
    Then the response content type should be "application/json"
    And the response status code should be "200"
    And the response time should be less than 2000 milliseconds


  Scenario: Display the user details using POJO class
    When Get user by username
    And the response status code should be "200"
