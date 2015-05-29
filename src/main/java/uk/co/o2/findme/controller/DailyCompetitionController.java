package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/competition")
public class DailyCompetitionController {


    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        final PersonDAO currentUser = personModel.getPersonById(Integer.parseInt(loginCookie.getValue()));
        Map<String, Object> model = new HashMap();
        model.put("currentUser", currentUser);
        return Response.ok().entity(new Viewable("/dailycompetition.ftl", model)).build();
    }
}
