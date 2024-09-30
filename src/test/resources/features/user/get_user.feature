Feature: Get user with name

  Background:
    Given the application is configured to connect to base url

  Scenario: User is displayed successfully by name
    When The admin sends a GET request to the "user" endpoint with user name "helloWorld"
    Then Verify that the status code is "200"
    And  Verify that the response userDetails contains required fields

