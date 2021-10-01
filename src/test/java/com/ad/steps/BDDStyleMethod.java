package com.ad.steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class BDDStyleMethod {

    public static void getPost(String pagenum){
        given().contentType(ContentType.JSON)
        .when()
                .get(String.format("https://reqres.in/api/users?page=%s", pagenum))
        .then()
                .body("total", equalTo(12));
    }
}
