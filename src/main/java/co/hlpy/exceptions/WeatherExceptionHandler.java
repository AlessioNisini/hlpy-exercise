package co.hlpy.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
public class WeatherExceptionHandler implements ExceptionMapper<WeatherException> {

    @ConfigProperty(name = "error.place-not-found")
    String placeNotFound;

    @ConfigProperty(name = "error.missing-place")
    String missingPlace;

    @ConfigProperty(name = "error.client-error")
    String clientError;

    @Override
    public Response toResponse(WeatherException e) {

        if (e.getMessage().equalsIgnoreCase(placeNotFound))
            return Response
                .status(Response.Status.NOT_FOUND)
                .entity(
                    new ErrorMessage(
                        e.getMessage(),
                        Response.Status.NOT_FOUND.getStatusCode()
                    )
                )
                .build();
        else if (e.getMessage().equalsIgnoreCase(missingPlace))
            return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(
                    new ErrorMessage(
                        e.getMessage(),
                        Response.Status.BAD_REQUEST.getStatusCode()
                    )
                )
                .build();
        else if (e.getMessage().equalsIgnoreCase(clientError))
            return Response
                .status(Response.Status.BAD_GATEWAY)
                .entity(
                    new ErrorMessage(
                        e.getMessage(),
                        Response.Status.BAD_GATEWAY.getStatusCode()
                    )
                )
                .build();
        else
            return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(
                    new ErrorMessage(
                        e.getMessage(),
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                    )
                )
                .build();

    }

}