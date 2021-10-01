package com.ad;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TestAuth {

    @Test
    public void testAuth(){

        RestAssured.baseURI = "http://bookstore.toolsqa.com";

        RequestSpecification request = given();

        String credentials = "TOOLSQA-Test:Test@@123";

        byte[] encoded = Base64.encodeBase64(credentials.getBytes());

        String encodedAsString = new String(encoded);

        //System.out.println(encodedAsString);

        request.header("Authorization", "Basic" +encodedAsString);

        String payload = "{\n" +
                "  \"userId\": \"9b5f49ab-eea9-45f4-9d66-bcf56a531b85\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"978149178541247\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        request.header("Content-Type", "application/json");

        Response response = request.body(payload).post("/BookStore/v1/Books");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
}
