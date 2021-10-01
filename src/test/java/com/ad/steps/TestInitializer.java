package com.ad.steps;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class TestInitializer {

    @Before
    public void testSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
