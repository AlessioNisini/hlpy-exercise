package co.hlpy.services;

import co.hlpy.exceptions.WeatherException;
import jakarta.enterprise.context.ApplicationScoped;

import co.hlpy.clients.WeatherClient;
import co.hlpy.models.Place;
import co.hlpy.models.WeatherReportDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class WeatherService {

    @RestClient
    WeatherClient weatherClient;

    @ConfigProperty(name = "openweathermap.appid")
    String apiKey;

    @ConfigProperty(name = "openweathermap.unit-of-measurement")
    String unitOfMeasurement;

    @ConfigProperty(name = "error.place-not-found")
    String placeNotFound;

    public CompletionStage<List<WeatherReportDTO>> getWeather(String placeName) {

       return  weatherClient
            .getGeoCoordinates(placeName, 1, apiKey)
            .thenComposeAsync(places -> {
                Place place = places.stream().findFirst().orElseThrow(() -> new WeatherException(placeNotFound));
                return weatherClient.getWeather(
                    place.getLat(),
                    place.getLon(),
                    unitOfMeasurement,
                    apiKey
                );
            })
            .thenApply(weatherReport ->
                weatherReport
                    .getDaily()
                    .stream()
                    .skip(1)
                    .limit(5)
                    .map(WeatherReportDTO::fromDay)
                    .toList()
            );

    }

}
