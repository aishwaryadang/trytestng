package com.ad.steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.CoreMatchers.*;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetPostSteps {

    private static ResponseOptions<Response> response;

    @Given(value = "I perform GET operation for total on {string} with path parameters")
    public void iPerformGETOperationForTotalOn(String url, DataTable table) {
        HashMap<String, String> body = new HashMap<>();
        body.put("page", table.cell(1,0));

        response = RestAssuredExtension.getWithParams(url, body);
    }

    @Then("I should see total as {int}")
    public void iShouldSeeTotalAs(int total) {
        assertThat(response.getBody().jsonPath().get("total"), CoreMatchers.<Object>equalTo(total));
    }

    @Given(value = "I perform POST operation for {string} with body")
    public void iPerformPOSTOperationFor(String url, DataTable table) {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", table.cell(1,0));
        body.put("job", table.cell(1,1));

        response = RestAssuredExtension.postWithBodyParams(url, body);
    }

    @Then("I should see body has name {string}")
    public void i_should_see_body_has_name(String string) {
        assertThat(response.getBody().jsonPath().get("name"), CoreMatchers.<Object>equalTo(string));
    }

    @Given("I perform DELETE operation for {string}")
    public void iPerformDeleteOperationFor(String url) {
        response = RestAssuredExtension.delete(url);
    }

    @And("I perform GET operation for {string}")
    public void iPerformGetOperationFor(String url) {
        response = RestAssuredExtension.getWithoutParams(url);
    }

    @Then("I should not see body with first_name {string}")
    public void iShouldNotSeeBodyWithFirstName(String string) {
        assertThat(response.getBody().jsonPath().get("first_name"), CoreMatchers.<Object>not(string));
    }


}
