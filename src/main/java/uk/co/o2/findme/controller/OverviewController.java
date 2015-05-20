package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.serverError;


@Path("/")
public class OverviewController {

    private final SearchModel searchModel = FindMe.findme().searchModel;

    @GET
    public Response overview(@CookieParam(value = "facewallLoggedIn") Cookie loginCookie) {
            return Response.ok().entity(new Viewable("/homepage.ftl")).build();
    }




    @GET
    @Path("/results")
    public Response searchResults(@DefaultValue("") @QueryParam("keywords") String keywords, @CookieParam(value = "facewallLoggedIn") Cookie loginCookie) {
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
}
