package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/connect/{id}")
public class ConnectionController {


    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response overview(@PathParam("id") String id) {
        Map<String, Object> model = new HashMap();
        model.put("targetPerson", id);
        return Response.ok().entity(new Viewable("/connect.ftl", model)).build();
    }

    @POST
    @Path("/add")
    public Response connect(@PathParam("id") String id, @FormParam("email") String email) {

        String userID = personModel.getPersonIdByEmail(email);
        String targetUserID = id;
        Map<String, Object> model = new HashMap();

        if(personModel.checkIfConnectionIsAlreadyPresent(userID, targetUserID)) {
            model.put("beenAdded", "false");
        } else {
            personModel.addPersonToStickerBook(userID, targetUserID);
            model.put("beenAdded", "true");
        }

        return Response.ok().entity(new Viewable("/connect.ftl", model)).build();
    }
}
