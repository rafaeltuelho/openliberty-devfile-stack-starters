package dev.odo.starter;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingsResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello " + name;
    }

}