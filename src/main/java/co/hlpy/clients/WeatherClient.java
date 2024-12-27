package co.hlpy.clients;

import co.hlpy.exceptions.WeatherException;
import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import co.hlpy.models.Place;
import co.hlpy.models.WeatherReport;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.concurrent.CompletionStage;


@RegisterRestClient(configKey="weather-api")
public interface WeatherClient {

    @GET
    @Path("/geo/1.0/direct")
    CompletionStage<List<Place>> getGeoCoordinates(
        @QueryParam("q") String q,
        @QueryParam("limit") Integer limit,
        @QueryParam("appid") String apiKey
    );

    @GET
    @Path("/data/3.0/onecall")
    CompletionStage<WeatherReport> getWeather(
        @QueryParam("lat") Double lat,
        @QueryParam("lon") Double lon,
        @QueryParam("units") String units,
        @QueryParam("appid") String apiKey
    );

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {

        String errorMsg = ConfigProvider.getConfig().getValue("error.client-error", String.class);
        if (response.getStatus() >= 400) {
            return new WeatherException(errorMsg);
        }
        return null;

    }

}
