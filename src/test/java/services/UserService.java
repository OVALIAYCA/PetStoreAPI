package services;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import pojos.User;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static final SoftAssert softAssert = new SoftAssert();
    private static final Faker faker = new Faker();

    private static int getRandomId() {
        return faker.number().numberBetween(10, 1000);
    }

    public static String userName;


    public static Map<String, Object> createUserData(String id, String userName, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", id);
        userData.put("username", userName);
        userData.put("firstName", firstName);
        userData.put("lastName", lastName);
        userData.put("email", email);
        userData.put("password", password);
        userData.put("phone", phone);
        userData.put("userStatus", userStatus);
        return userData;
    }

    public static void verifyUserDetails(String responseBody) {
        softAssert.assertTrue(responseBody.contains("id"), "ID not found");
        softAssert.assertTrue(responseBody.contains("username"), "Username not found");
        softAssert.assertTrue(responseBody.contains("firstName"), "First name not found");
        softAssert.assertTrue(responseBody.contains("lastName"), "Last name not found");
        softAssert.assertTrue(responseBody.contains("email"), "Email not found");
        softAssert.assertTrue(responseBody.contains("password"), "Password not found");
        softAssert.assertTrue(responseBody.contains("phone"), "Phone not found");
        softAssert.assertTrue(responseBody.contains("userStatus"), "User status not found");
        softAssert.assertAll();
    }


    public static String getUserName() {
        return userName;
    }

    public static Response postUser() {
        userName = faker.name().username();
        User user = User.builder()
                .id(getRandomId())
                .username(userName)
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(faker.number().numberBetween(1, 10))
                .build();

        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/user");
    }


}
