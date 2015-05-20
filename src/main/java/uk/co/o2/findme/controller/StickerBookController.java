package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

@Path("/stickerBook")
public class StickerBookController {

    private PersonModel personModel = new PersonModel();

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") String id, @CookieParam(value = "facewallLoggedIn") Cookie loginCookie) {
        //final int personID = Integer.parseInt(id);
        //final PersonDAO person = personModel.getPersonById(personID);
        return Response.ok().entity(new Viewable("/digitalStickerBook.ftl")).build();
    }
}
