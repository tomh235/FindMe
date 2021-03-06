package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
public class PersonController {

    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") String id, @CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                return Response.ok().entity(new Viewable("/login.ftl")).build();
            } else {
                if (!personModel.isValidPersonID(loginCookie.getValue())) {
                    return Response.ok().entity(new Viewable("/login.ftl")).build();
                } else {
                    Map<String, Object> model = new HashMap();
                    final String personID = id;
                    final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
                    final PersonDAO person = personModel.getPersonById(personID);
                    final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
                    final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
                    model.put("currentUser", currentUser);
                    model.put("person", person);
                    model.put("stickerCount", numberOfStickers);
                    model.put("hasPlayed", hasPlayed);
                    return Response.ok().entity(new Viewable("/singleperson.ftl", model)).build();
                }
            }
        } catch (NullPointerException e) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
        }
    }
}
