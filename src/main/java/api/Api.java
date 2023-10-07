package api;

import io.restassured.RestAssured;

public class Api {

    public static final String BURGER_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String BURGER_API_USER_AUTH = "api/auth/login";
    public static final String BURGER_API_USER_DELETE = "api/auth/user";
    public static final String BURGER_API_USER_CREATE = "api/auth/register";

    protected static void setUp() {
        RestAssured.baseURI = BURGER_URL;
    }
}