package co.hlpy.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class WeatherControllerITest {

    @Test
    void testGetWeatherSuccess() {
        String placeName = "Bologna";

        given()
            .when().get("/api/weather?place=" + placeName)
            .then()
            .statusCode(200)
            .body("size()", is(1))
            .body("get(0).timestamp", is(2));
    }

}