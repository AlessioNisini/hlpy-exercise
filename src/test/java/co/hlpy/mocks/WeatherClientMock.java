package co.hlpy.mocks;

import co.hlpy.clients.WeatherClient;
import co.hlpy.models.Day;
import co.hlpy.models.Place;
import co.hlpy.models.WeatherReport;
import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Mock
@ApplicationScoped
@RestClient
public class WeatherClientMock implements WeatherClient {

    @Override
    public CompletionStage<List<Place>> getGeoCoordinates(String q, Integer limit, String apiKey) {
        return switch (q) {
            case "Milan" ->
                CompletableFuture.completedFuture(List.of(new Place("Milan", 45D, 9D)));
            case "Bologna" ->
                CompletableFuture.completedFuture(List.of(new Place("Bologna", 44D, 11D)));
            default ->
                CompletableFuture.completedFuture(Collections.emptyList());
        };
    }

    @Override
    public CompletionStage<WeatherReport> getWeather(Double lat, Double lon, String units, String apiKey) {
        Day day1 = new Day(), day2 = new Day(), day3 = new Day(), day4 = new Day(), day5 = new Day(), day6 = new Day(), day7 = new Day();
        day1.setDt(1L);
        day2.setDt(2L);
        day3.setDt(3L);
        day4.setDt(4L);
        day5.setDt(5L);
        day6.setDt(6L);
        day7.setDt(7L);

        List<Day> days = lat == 45D ? List.of(day1, day2, day3, day4, day5, day6, day7) : List.of(day1, day2);

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setDaily(days);

        return CompletableFuture.completedFuture(weatherReport);
    }
}