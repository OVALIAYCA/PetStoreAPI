@UserOperations
Feature: Create new user

  Background:
    Given the application is configured to connect to base url


  Scenario Outline: Create new user successfully
    When The admin sends a POST request to the "user" endPoint with "<id>" and "<username>" and "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<phone>" and "<userStatus>"
    Then Verify that the content type is "application/json"
    And Verify that the status code is "200"
    Then Verify that the response contains the required fields

    Examples:
      | id | username | firstName | lastName | email | password | phone     | userStatus |
      | 1  | testUser | test      | test     | test  | 123456   | 123456789 | 90         |


  Scenario Outline: Update user successfully
    When The admin sends a PUT request to the "user" endPoint with "<id>" and "<username>" and "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<phone>" and "<userStatus>"
    Then Verify that the content type is "application/json"
    And Verify that the status code is "200"
    Then Verify that the response contains the required fields

    Examples:
      | id | username | firstName | lastName | email   | password | phone     | userStatus |
      | 10 | testUser | updated   | user     | updated | 654321   | 987654321 | 1          |


  Scenario: User is displayed successfully by name
    When The admin sends a GET request to the "user" endpoint with user name "testUser"
    Then Verify that the status code is "200"
    And  Verify that the response userDetails contains required fields


  Scenario: User is deleted successfully by name
    When The admin sends a DELETE request to the "user" endpoint with query params "testUser"
    Then Verify that the status code is "200"