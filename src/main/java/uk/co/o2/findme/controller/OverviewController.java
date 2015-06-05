package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.serverError;


@Path("/")
public class OverviewController {

    private final SearchModel searchModel = FindMe.findme().searchModel;
    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response overview(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
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
                    System.out.println(randomUUID().toString());
                    Map<String, Object> model = new HashMap();
                    model.put("currentUser", currentUser);
                    model.put("popCount", populationCount);
                    model.put("stickerCount", numberOfStickers);
                    model.put("hasPlayed", hasPlayed);
                    return Response.ok().entity(new Viewable("/homepage.ftl", model)).build();
                }
            }
        } catch (NullPointerException e) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
        }
    }

    @GET
    @Path("/results")
    public Response searchResults(@DefaultValue("") @QueryParam("keywords") String keywords, @CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        final SearchResultsModel searchResults = searchModel.search(keywords);
        //TODO: This looks like scala code that has been translated into java. That's fine, but this kind of java code should be avoided if possible. Hopefully we can design it away.
        Response.ResponseBuilder response = serverError();
        if (searchResults instanceof DefaultSearchResultsModel) {
            response = ok(new Viewable("/searchresults.ftl", searchResults));
        } else if (searchResults instanceof PersonDAO) {
            response = ok(new Viewable("/persondetails.ftl", searchResults));
        }
        return response.build();
    }


    @GET
    @Path("/logout")
    public Response logout() {
        NewCookie loginCookie = new NewCookie("findmeLoggedIn", "null");
        URI login = null;
        try {
            login = new URI("/login");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.seeOther(login).cookie(loginCookie).build();
    }
}
