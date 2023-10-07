package url;

import api.Api;
import io.restassured.RestAssured;


public class UrlApiBase {

    protected static void setUp() {
        RestAssured.baseURI = Api.BURGER_URL;
    }
}
