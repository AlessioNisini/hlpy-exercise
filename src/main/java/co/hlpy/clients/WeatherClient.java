package co.hlpy.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import co.hlpy.models.Place;
import co.hlpy.models.WeatherReport;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


@RegisterRestClient(configKey="weather-api")
public interface WeatherClient {

    @GET
    @Path("/geo/1.0/direct")
    List<Place> getGeoCoordinates(
        @QueryParam("q") String q,
        @QueryParam("limit") Integer limit,
        @QueryParam("appid") String apiKey
    );

    @GET
    @Path("/data/3.0/onecall")
    WeatherReport getWeather(
        @QueryParam("lat") Double lat,
        @QueryParam("lon") Double lon,
        @QueryParam("units") String units,
        @QueryParam("appid") String apiKey
    );

}
