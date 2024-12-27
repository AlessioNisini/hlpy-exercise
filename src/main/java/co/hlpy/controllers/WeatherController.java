package co.hlpy.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import co.hlpy.models.WeatherReportDTO;
import co.hlpy.services.WeatherService;

import java.util.List;

@Path("/api/weather")
public class WeatherController {

    @Inject
    WeatherService weatherService;

    @GET
    public List<WeatherReportDTO> getWeather(@QueryParam("place") String place) {

        return weatherService.getWeather(place);

    }
}
