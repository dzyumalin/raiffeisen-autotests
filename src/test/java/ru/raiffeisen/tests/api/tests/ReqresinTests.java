package ru.raiffeisen.tests.api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static ru.raiffeisen.tests.api.Specs.request;
import static ru.raiffeisen.tests.api.Specs.responseSpec;

@Owner("Dmitriy")
@Layer("Api")
@Feature("Reqres")
public class ReqresinTests {

    @Test
    @Tag("Api")
    @Description("Main page")
    @DisplayName("Get and check list user data")
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
