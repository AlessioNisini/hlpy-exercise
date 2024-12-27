package co.hlpy.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/healthcheck")
public class HealthcheckController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() {

        return "Service up and running ...";

    }
}
