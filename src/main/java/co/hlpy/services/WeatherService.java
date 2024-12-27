package co.hlpy.services;

import jakarta.enterprise.context.ApplicationScoped;

import co.hlpy.clients.WeatherClient;
import co.hlpy.models.Place;
import co.hlpy.models.WeatherReport;
import co.hlpy.models.WeatherReportDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class WeatherService {

    @RestClient
    WeatherClient weatherClient;

    @ConfigProperty(name = "openweathermap.appid")
    String apiKey;

    @ConfigProperty(name = "openweathermap.unit-of-measurement")
    String unitOfMeasurement;

    public List<WeatherReportDTO> getWeather(String placeName) {

        Place place = weatherClient.getGeoCoordinates(placeName, 1, apiKey).get(0);

        WeatherReport weatherReport = weatherClient.getWeather(
            place.getLat(),
            place.getLon(),
            unitOfMeasurement,
            apiKey
        );

        return weatherReport
            .getDaily()
            .stream()
            .skip(1)
            .limit(5)
            .map(WeatherReportDTO::fromDay)
            .toList();

    }

}
