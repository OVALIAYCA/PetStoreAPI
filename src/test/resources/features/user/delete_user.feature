Feature: Delete user with name

  Background:
    Given the application is configured to connect to base url

  Scenario: User is deleted successfully by name
    When The admin sends a DELETE request to the "user" endpoint with query params "helloWorld"
    Then Verify that the status code is "200"