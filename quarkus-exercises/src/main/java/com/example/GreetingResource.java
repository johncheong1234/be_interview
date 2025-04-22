package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/greet")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greetWithSuffix(
            @PathParam("name") String name,
            @QueryParam("suffix") String suffix) {
        
        String greeting = greetingService.greet(name);
        if (suffix != null && !suffix.isBlank()) {
            greeting += " " + suffix;
        }
        return greeting + "!";
    }
}