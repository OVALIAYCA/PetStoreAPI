
# PetStore API Testing Framework

## Overview

This project is a testing framework for the PetStore API. It uses Java and Maven for managing dependencies and running tests. The framework includes various test scenarios for creating, updating, and retrieving user information.

## Prerequisites

- Java 17 (Amazon Corretto 17.0.11)
- Maven


## Features

- **Pojo Usage**: The framework uses POJO classes to represent user data, ensuring type safety and ease of use.
- **ResponseLoggingFilter**: Integrated `ResponseLoggingFilter` to log HTTP responses for better debugging and traceability.
- **Cucumber Report**: Configured Cucumber to generate detailed test reports, providing insights into test execution.
- **Lombok and Jackson Annotations**: Utilized Lombok for reducing boilerplate code and Jackson annotations for JSON serialization/deserialization.
- **Post with Random Data**: Leveraged `java-faker` library to generate random data for POST requests, enhancing test coverage and robustness.

## Dependencies

The project uses the following dependencies:

- **Cucumber**: For writing and running BDD tests.
- **RestAssured**: For testing REST APIs.
- **TestNG**: For running tests with soft assertions.
- **JUnit 5**: For running unit tests.
- **Gson**: For JSON parsing.
- **Jackson**: For JSON serialization/deserialization.
- **JavaFaker**: For generating random data.
- **Lombok**: For reducing boilerplate code.
- **Jakarta Validation**: For validating POJO fields.


## Project Structure

```
src
└──test
   ├── java
   │   └── stepDefs
   │       └── PetStoreSteps.java
   └── resources
       └── features
           └── user
               └── post_user.feature
```

## Running Tests

To run the tests, use the following Maven command:

```sh
mvn clean test
```

## Test Scenarios

### Create New User

This scenario tests the creation of a new user.

```gherkin
Scenario Outline: Create new user successfully
  When The admin sends a POST request to the "user" endPoint with "<id>" and "<username>" and "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<phone>" and "<userStatus>"
  Then Verify that the content type is "application/json"
  And Verify that the status code is "200"
  Then Verify that the response contains the required fields

Examples:
  | id  | username | firstName | lastName | email | password | phone | userStatus |
  | 1   | testUser | test      | test     | test  | 123456   | 123456789 | 90 |
```

### Update User

This scenario tests updating an existing user.

```gherkin
Scenario Outline: Update user successfully
  When The admin sends a PUT request to the "user" endPoint with "<id>" and "<username>" and "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<phone>" and "<userStatus>"
  Then Verify that the content type is "application/json"
  And Verify that the status code is "200"
  Then Verify that the response contains the required fields

Examples:
  | id  | username | firstName | lastName | email | password | phone | userStatus |
  | 10  | testUser | updated   | user     | updated | 654321 | 987654321 | 1 |
```

### Generate a New User

This scenario tests generating a new user using a POJO class.

```gherkin
Scenario: Generate a new user using POJO class
  When The admin generate a new user
  Then the response content type should be "application/json"
  And the response status code should be "200"
  And the response time should be less than 2000 milliseconds
```

### Display User Details

This scenario tests retrieving user details using a POJO class.

```gherkin
Scenario: Display the user details using POJO class
  When Get user by username
  And the response status code should be "200"
```
