package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.StickerBookPersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/stickerBook")
public class StickerBookController {


    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
        final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
        final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
        final List<StickerBookPersonDAO> stickerBookPersonList = personModel.getPeopleInStickerBookFor(loginCookie.getValue());
        Map<String, Object> model = new HashMap();
        model.put("currentUser", currentUser);
        model.put("stickerCount", numberOfStickers);
        model.put("hasPlayed", hasPlayed);
        model.put("stickerBookPersonList", stickerBookPersonList);
        return Response.ok().entity(new Viewable("/digitalStickerBook.ftl", model)).build();
    }
}
