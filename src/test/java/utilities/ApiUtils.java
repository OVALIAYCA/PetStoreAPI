package utilities;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static request.AllRequests.response;

public class ApiUtils {

    public static void validateMapKeys(Map<String, Object> map, List<String> expectedKeys) {
        for (String expectedKey : expectedKeys) {
            if (!map.containsKey(expectedKey)) {
                throw new AssertionError("Response body does not contain the expected key: " + expectedKey);
            }
        }
    }

    public static void verifyThatStatusCodeIs(String statusCode) {
        assertEquals(statusCode, String.valueOf(response.statusCode()));
    }

    public static void verifyThatContentTypeIs(String contentType) {
        if (response.statusCode() != 401 && response.statusCode() != 204)
            assertEquals(response.contentType(), contentType);
    }

    public static void verifyThatStatusCodeIs(Response response, String statusCode) {
        assertEquals(statusCode, String.valueOf(response.statusCode()));
    }

    public static void verifyThatContentTypeIs(Response response, String contentType) {
        if (response.statusCode() != 401 && response.statusCode() != 204)
            assertEquals(response.contentType(), contentType);
    }
}
