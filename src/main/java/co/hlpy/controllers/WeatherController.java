package co.hlpy.controllers;

import co.hlpy.exceptions.WeatherException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import co.hlpy.models.WeatherReportDTO;
import co.hlpy.services.WeatherService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/api/weather")
public class WeatherController {

    @Inject
    WeatherService weatherService;

    @ConfigProperty(name = "error.missing-place")
    String missingPlace;

    @GET
    public CompletionStage<List<WeatherReportDTO>> getWeather(@QueryParam("place") String place) {

        if(place == null || place.trim().isEmpty()) throw new WeatherException(missingPlace);

        return weatherService.getWeather(place.trim());

    }
}
