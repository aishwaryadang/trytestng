package com.ad;


import com.ad.DataForTests.DataProvisiong;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestPost extends DataProvisiong {

    @Test(dataProvider = "dataForPost")
    public void testPost(String name, String job){

        JSONObject jsonResult = new JSONObject();

        jsonResult.put("name", name);
        jsonResult.put("job", job);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonResult)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201);
    }
}
