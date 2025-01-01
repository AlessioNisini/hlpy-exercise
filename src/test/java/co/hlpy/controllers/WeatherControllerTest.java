package co.hlpy.controllers;

import co.hlpy.services.WeatherService;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class WeatherControllerTest {

    @Test
    void testGetWeatherSuccess() {
        String placeName = "Milan";

        WeatherService mock = Mockito.mock(WeatherService.class);
        Mockito.when(mock.getWeather(placeName)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));
        QuarkusMock.installMockForType(mock, WeatherService.class);

        given()
            .when().get("/api/weather?place=" + placeName)
            .then()
            .statusCode(200)
            .body("size()", is(0));
    }

    @Test
    void testGetWeatherFailMissingPlace() {
        given()
          .when().get("/api/weather")
          .then()
             .statusCode(400)
             .body("message", is("missing place"))
             .body("status", is(400));
    }

}