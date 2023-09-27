package serialization;

import api.Api;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pens.PensUser;
import url.UrlApiBase;

import static io.restassured.RestAssured.given;

public class SerializationUser extends UrlApiBase {

    @Step("DELETE /api/auth/user")
    public static Response deleteUser(String accessToken) {
        setUp();
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(Api.BURGER_API_USER_DELETE);
    }

    @Step("POST /api/auth/login")
    public static Response loginUser(PensUser pensUser) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(pensUser)
                .when()
                .post(Api.BURGER_API_USER_AUTH);
    }

    @Step("POST /api/auth/register")
    public static Response createUser(PensUser pensUser) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .body(pensUser)
                .when()
                .post(Api.BURGER_API_USER_CREATE);
    }
}
