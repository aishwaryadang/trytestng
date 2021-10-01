package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification requestSpecification;

    //Arrange
    public RestAssuredExtension() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = RestAssured.given().spec(requestSpecBuilder.build());
    }

    //Act
    public static ResponseOptions<Response> getWithParams(String url, Map<String, String> params){
        //requestSpecification.pathParams(params);
        requestSpecification.queryParams(params);
        try {
            return requestSpecification.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ResponseOptions<Response> getWithoutParams(String url) {

        try {
            //System.out.println(url);
            //System.out.println(new URI(url));
            return requestSpecification.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ResponseOptions<Response> postWithBodyParams(String url, Map<String, String> body) {
        requestSpecification.body(body);
        try {
            return requestSpecification.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ResponseOptions<Response> delete(String url) {
        try {
            return requestSpecification.delete(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

}
