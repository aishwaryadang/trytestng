package com.ad;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestPut {

    @Test
    public void testPut() {
/*
        Map<String, Object> map = new HashMap<>();
        map.put("Munna Bhai", "Dhobi");
        map.put("Ibu Hatela", "Comedian");

        ObjectMapper om = new ObjectMapper();

        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(map);


        System.out.println(map);
        System.out.println(jsonResult);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonResult)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
 */   }
}
