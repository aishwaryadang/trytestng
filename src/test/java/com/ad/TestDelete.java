package com.ad;

import com.ad.DataForTests.DataProvisiong;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TestDelete extends DataProvisiong {


    @Test(dataProvider = "DataForDelete")
    public void testDelete(int id) throws JsonProcessingException {

//        Map<String, Object> map = new HashMap<>();
//        map.put("Munna Bhai", "Dhobi");
//        map.put("Ibu Hatela", "Comedian");
//
//        ObjectMapper om = new ObjectMapper();
//
//        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(map);

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("id", id);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonResult)
        .when()
                .delete("https://reqres.in/api/users/2")
        .then()
                .statusCode(204);
    }
}
