package stepDefs;

import io.cucumber.java.en.And;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import services.UserService;
import utilities.ConfigurationsReader;
import utilities.constants.FrameworkConstants;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;
import static request.AllRequests.*;
import static utilities.ApiUtils.verifyThatContentTypeIs;
import static utilities.ApiUtils.verifyThatStatusCodeIs;

public class PetStoreSteps {

    private Response response;
    private String userName;

    @Given("the application is configured to connect to base url")
    public void the_application_is_configured_to_connect_to_base_url() {
        RestAssured.baseURI = ConfigurationsReader.getProperty(FrameworkConstants.BASE_URL);
        RestAssured.filters(new ResponseLoggingFilter());
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @When("The admin sends a GET request to the {string} endpoint with user name {string}")
    public void the_admin_sends_a_get_request_to_the_endpoint_with_user_name(String endpoint, String userName) {
        response = getUser(endpoint, userName);
    }

    @Then("Verify that the status code is {string}")
    public void verifyThatTheStatusCodeIs(String expectedStatusCode) {
        verifyThatStatusCodeIs(expectedStatusCode);
    }

    @Then("Verify that the response userDetails contains required fields")
    public void verify_that_the_response_userDetails_contains_required_fields() {
        String responseBody = response.getBody().asString();
        UserService.verifyUserDetails(responseBody);
    }

    @And("Verify that the content type is {string}")
    public void verifyThatTheContentTypeIs(String contentType) {
        verifyThatContentTypeIs(contentType);
    }

    @When("The admin sends a DELETE request to the {string} endpoint with query params {string}")
    public void theAdminSendsADELETERequestToTheEndpointWithQueryParams(String endPoint, String userName) {
        response = deleteUser(endPoint, userName);

    }

    @When("The admin sends a POST request to the {string} endPoint with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void theAdminSendsAPOSTRequestToTheEndPointWithAndAndAndAndAndAndAnd(String endpoint, String id, String userName, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        response = postUser(endpoint, id, userName, firstName, lastName, email, password, phone, userStatus);

    }

    @Then("Verify that the response contains the required fields")
    public void verifyThatTheResponseContainsRequiredFields() {
        Map<String, Object> responseBody = response.jsonPath().getMap("");
        String[] requiredFields = {"code", "type", "message"};
        for (String field : requiredFields) {
            assertTrue("Response body does not contain '" + field + "'", responseBody.containsKey(field));
        }
    }

    @When("The admin generate a new user")
    public void theAdminGenerateANewUser() {
        response = UserService.postUser();
        userName = UserService.getUserName();
        System.out.println("User name: " + userName);
    }

    @And("the response time should be less than {int} milliseconds")
    public void theResponseTimeShouldBeLessThanMilliseconds(int responseTime) {

        long time = response.then().extract().time();
        Assertions.assertTrue(time <= responseTime);
    }

    @Then("the response status code should be {string}")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        verifyThatStatusCodeIs(response, statusCode);

    }

    @Then("the response content type should be {string}")
    public void theResponseHeaderShouldBe(String value) {
        verifyThatContentTypeIs(response, value);
    }

    @When("Get user by username")
    public void getUserByUsername() {
        response = getUser("user", UserService.getUserName());

    }

    @When("The admin sends a PUT request to the {string} endPoint with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void theAdminSendsAPUTRequestToTheEndPointWithAndAndAndAndAndAndAndUserStatus(String endpoint, String id, String userName, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        response = putUser(endpoint, id, userName, firstName, lastName, email, password, phone, userStatus);
    }


}
