package com.ad;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestAuth2 {

    @Test
    public void testAuth2() {

        given()
                .auth().preemptive().basic("postman", "password")
        .when()
                .get("http://postman-echo.com/basic-auth")
        .then()
                .log().body()
                .statusCode(200)
                .body("authenticated", equalTo(true));

    }
}
