package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Path("/competition")
public class DailyCompetitionController {


    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
        final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
        final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
        final String guessString = personModel.getCompetitionPerson();
        Map<String, Object> model = new HashMap();
        model.put("currentUser", currentUser);
        model.put("stickerCount", numberOfStickers);
        model.put("hasPlayed", hasPlayed);
        model.put("guessString", guessString);
        return Response.ok().entity(new Viewable("/dailycompetition.ftl", model)).build();
    }

    @POST
    public Response submitUserEntry(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie, @FormParam("entry") String entry) {
        Map<String, Object> model = new HashMap();
        final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
        final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());

        model.put("currentUser", currentUser);
        model.put("stickerCount", numberOfStickers);

        String result = personModel.submitEntry(loginCookie.getValue(), entry);
        System.out.println(result);

        if(Objects.equals(result, "success")) {
            final boolean previouslyPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
            model.put("hasPlayed", previouslyPlayed);
            model.put("guessString", "All sorted! Your guess has been received. Thank you for playing and we hope you win!");
        } else if(Objects.equals(result, "fail")) {
            final boolean previouslyPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
            model.put("hasPlayed", previouslyPlayed);
            model.put("guessString", "Gosh! Something has gone wrong. Sorry about this. We'll look into it! (or try again)");
        }
        return Response.ok().entity(new Viewable("/dailycompetition.ftl", model)).build();
    }
}
