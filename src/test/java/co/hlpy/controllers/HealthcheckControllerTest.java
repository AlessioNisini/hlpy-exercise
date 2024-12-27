package co.hlpy.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class HealthcheckControllerTest {
    @Test
    void testHealthcheckEndpoint() {
        given()
          .when().get("/healthcheck")
          .then()
             .statusCode(200)
             .body(is("Service up and running ..."));
    }

}