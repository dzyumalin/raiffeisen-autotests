package ru.raiffeisen.tests.api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.JiraIssue;
import ru.raiffeisen.annotations.JiraIssues;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.tests.api.models.CreateUser;
import ru.raiffeisen.tests.api.models.User;
import ru.raiffeisen.tests.api.models.UserData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.raiffeisen.tests.api.Specs.*;

@Owner("Dmitriy")
@Layer("api")
@Feature("Reqres")
public class ReqresinTests {

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Get and check list user data")
    public void listResource() {
        given()
                .spec(request)
                .when()
                .get("/unknown")
                .then()
                .spec(responseSpec)
                .body("data.year", hasItem(2001), "data.color", hasItem("#7BC4C4"));
    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Get and check year at user data")
    public void listResourceYear() {
        given()
                .spec(request)
                .when()
                .get("/unknown")
                .then()
                .log().body()
                .body("data.findAll{it.year > 2004}.year.flatten()",
                        hasItem(2005));
    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Get and check single user data")
    public void singleResource() {
        UserData data =
                given()
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec)
                        .extract().as(UserData.class);

        assertEquals("janet.weaver@reqres.in", data.getUser().getEmail());
        assertEquals("https://reqres.in/img/faces/2-image.jpg", data.getUser().getAvatar());
    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Create user")
    public void createUser() {
        CreateUser createUser =
                given()
                        .spec(request)
                        .body("{\"name\": \"morpheus\"," +
                                "\"job\": \"leader\"}")
                        .when()
                        .post("/users")
                        .then()
                        .spec(createResponseSpec)
                        .extract().as(CreateUser.class);

        assertEquals("morpheus", createUser.getName());
        assertEquals("leader", createUser.getJob());

    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Update user")
    public void updateUser() {
        CreateUser createUser =
                given()
                        .spec(request)
                        .body("{\"name\": \"morpheus\"," +
                                "\"job\": \"zion resident\"}")
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(responseSpec)
                        .extract().as(CreateUser.class);

        assertEquals("morpheus", createUser.getName());
        assertEquals("zion resident", createUser.getJob());

    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Authorization")
    public void loginSuccessful() {
        User user =
                given()
                        .spec(request)
                        .body("{\"email\": \"eve.holt@reqres.in\"," +
                                "\"password\": \"cityslicka\"}")
                        .when()
                        .post("/login")
                        .then()
                        .spec(responseSpec)
                        .extract().as(User.class);

        assertEquals("QpwL5tke4Pnpja7X4", user.getToken());

    }

    @Test
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-9")})
    @Description("Main page")
    @DisplayName("Authorization error")
    public void loginUnSuccessful() {
        User user =
                given()
                        .spec(request)
                        .body("{\"email\": \"peter@klaven\"}")
                        .when()
                        .post("/login")
                        .then()
                        .spec(errorResponseSpec)
                        .extract().as(User.class);

        assertEquals("Missing password", user.getError());

    }

}
