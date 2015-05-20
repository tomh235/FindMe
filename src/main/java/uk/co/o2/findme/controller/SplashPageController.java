package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/splash")
public class SplashPageController {

    @GET
    public Viewable splashPage() {

        return new Viewable("/splashpage.ftl");
    }

}