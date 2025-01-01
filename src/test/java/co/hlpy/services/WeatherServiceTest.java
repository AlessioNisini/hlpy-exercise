package co.hlpy.services;

import co.hlpy.models.WeatherReportDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
class WeatherServiceTest {

    @Inject
    WeatherService weatherService;

    @ConfigProperty(name = "error.place-not-found")
    String placeNotFound;

    @Test
    void testGetWeatherSuccess() throws ExecutionException, InterruptedException {
        CompletionStage<List<WeatherReportDTO>> weather = weatherService.getWeather("Milan");

        List<WeatherReportDTO> weatherReportDTOs = weather.toCompletableFuture().get();
        assertEquals(5, weatherReportDTOs.size());
        assertEquals(2L, weatherReportDTOs.get(0).getTimestamp());
        assertEquals(3L, weatherReportDTOs.get(1).getTimestamp());
        assertEquals(4L, weatherReportDTOs.get(2).getTimestamp());
        assertEquals(5L, weatherReportDTOs.get(3).getTimestamp());
        assertEquals(6L, weatherReportDTOs.get(4).getTimestamp());
    }

    @Test
    void testGetWeatherFailPlaceNotFound() {
        CompletionStage<List<WeatherReportDTO>> weather = weatherService.getWeather("notFound");

        ExecutionException ee = assertThrows(ExecutionException.class, weather.toCompletableFuture()::get);
        assertEquals(placeNotFound, ee.getCause().getMessage());
    }

}