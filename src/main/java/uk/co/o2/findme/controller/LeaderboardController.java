package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.GameDataObject;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.StickerBookDataObject;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Path("/leaderboards")
public class LeaderboardController {


    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        final PersonDAO currentUser = personModel.getPersonById(loginCookie.getValue());
        final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
        final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
        final List<GameDataObject> gameDataLBList = personModel.getGameDataLeaderBoards();
        final List<StickerBookDataObject> stickerBookLBList = personModel.getStickerBookLeaderBoards();
        Map<String, Object> model = new HashMap();
        model.put("currentUser", currentUser);
        model.put("stickerCount", numberOfStickers);
        model.put("hasPlayed", hasPlayed);
        model.put("gameDataLBList", gameDataLBList);
        model.put("stickerBookLBList", stickerBookLBList);
        return Response.ok().entity(new Viewable("/leaderboards.ftl", model)).build();
    }
}
