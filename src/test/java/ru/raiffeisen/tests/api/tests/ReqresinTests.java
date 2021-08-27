package ru.raiffeisen.tests.api.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static ru.raiffeisen.tests.api.Specs.request;
import static ru.raiffeisen.tests.api.Specs.responseSpec;

public class ReqresinTests {

    @Test
    public void listResource() {
        given()
                .spec(request)
                .when()
                .get("/unknown")
                .then()
                .spec(responseSpec)
                .body("data.year", hasItem(2001))
                .body("data.color", hasItem("#7BC4C4"));
    }

}
