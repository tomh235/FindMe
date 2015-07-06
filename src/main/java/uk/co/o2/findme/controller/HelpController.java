package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.DefaultSearchResultsModel;
import uk.co.o2.findme.model.PersonModel;
import uk.co.o2.findme.model.SearchModel;
import uk.co.o2.findme.model.SearchResultsModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.serverError;


@Path("/help")
public class HelpController {

    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response help(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                return Response.ok().entity(new Viewable("/login.ftl")).build();
            } else {
                if (!personModel.isValidPersonID(loginCookie.getValue())) {
                    return Response.ok().entity(new Viewable("/login.ftl")).build();
                } else {
                    final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
                    final String populationCount = personModel.getNumberOfPeopleInDatabase();
                    final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
                    final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());

                    Map<String, Object> model = new HashMap();
                    model.put("currentUser", currentUser);
                    model.put("popCount", populationCount);
                    model.put("stickerCount", numberOfStickers);
                    model.put("hasPlayed", hasPlayed);
                    return Response.ok().entity(new Viewable("/help.ftl", model)).build();
                }
            }
        } catch (NullPointerException e) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
        }
    }
}
