package request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import services.UserService;

import static io.restassured.RestAssured.given;

public class AllRequests {

    public static Response response;

    public static Response getUser(String endpoint, String userName) {
        response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("userName", userName)
                .when()
                .get(endpoint + "/{userName}");

        response.prettyPrint();
        return response;
    }

    public static Response deleteUser(String endPoint, String userName) {
        response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("userName", userName)
                .when()
                .delete(endPoint + "/{userName}");

        response.prettyPrint();
        return response;
    }

    public static Response postUser(String endpoint, String id, String userName, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .and()
                .body(UserService.createUserData(id, userName, firstName, lastName, email, password, phone, userStatus))
                .when()
                .post(endpoint);
        response.prettyPrint();
        return response;
    }

    public static Response putUser(String endpoint, String id, String userName, String firstName, String lastName, String email, String password, String phone, String
            userStatus) {
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .and()
                .body(UserService.createUserData(id, userName, firstName, lastName, email, password, phone, userStatus))
                .when()
                .pathParam("userName", userName)
                .put(endpoint + "/{userName}");
        response.prettyPrint();
        return response;
    }

}
