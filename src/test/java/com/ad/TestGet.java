package com.ad;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class TestGet {

    @Test
    public void testFirst(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testSecond(){

        given()
                .queryParam("page", "2")
        .when()
                .get("https://reqres.in/api/users")
         .then()
                .statusCode(200)
                .body("total", equalTo(12));

    }

    @Test
    public void testGet() {
        given()
                .get("https://reqres.in/api/users?page=2")
         .then()
                .statusCode(200)
                .log().body()
                .body("data.first_name", hasItems("Rachel", "George", "Byron"))
                .body("total", equalTo(12))
                .body("data[0].id", equalTo(7));
    }
}
