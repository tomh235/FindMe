package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.model.PersonModel;
import uk.co.o2.findme.model.SaltAndHashModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Path("/connect/{id}")
public class ConnectionController {


    private final PersonModel personModel = FindMe.findme().personModel;
    private final SaltAndHashModel saltAndHashModel = FindMe.findme().saltAndHashModel;

    @GET
    public Response connect(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie, @PathParam("id") String id) {
        Map<String, Object> model = new HashMap<String, Object>();
        Response response = null;

        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                model.put("isLoggedIn", "false");
                model.put("targetPerson", id);
                response = Response.ok().entity(new Viewable("/connect.ftl", model)).build();
            } else {
                if (!personModel.isValidPersonID(loginCookie.getValue())) {
                    model.put("isLoggedIn", "false");
                    model.put("targetPerson", id);
                    response = Response.ok().entity(new Viewable("/connect.ftl", model)).build();
                } else {
                    model.put("isLoggedIn", "true");
                    response = Response.seeOther(new URI("/FindMe/connect/" + id + "/add")).build();
                }
            }
        } catch (NullPointerException e) {
            model.put("isLoggedIn", "false");
            model.put("targetPerson", id);
            response = Response.ok().entity(new Viewable("/connect.ftl", model)).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    @POST
    @Path("/login")
    public Response submitLogin(@PathParam("id") String id, @FormParam("email") String email, @FormParam("password") String password) throws Exception {
        if (!personModel.isEmailAddressExistingForLogin(email)) {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("email", email);
            model.put("beenAdded", "false");
            Viewable failedLogin = new Viewable("/connect.ftl", model);
            System.out.println("Failed on wrong email");
            return Response.ok().entity(failedLogin).build();
        } else {
            SaltAndHashDAO saltAndPassword = personModel.getSaltFor(email);
            if(!saltAndHashModel.generateHashAndValidate(saltAndPassword, password)) {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("email", email);
                model.put("beenAdded", "false");
                Viewable failedLogin = new Viewable("/connect.ftl", model);
                System.out.println("Failed on wrong password");
                return Response.ok().entity(failedLogin).build();
            } else {
                //String sessionValue = personModel.getEncryptedSessionId(email);
                String sessionValue = personModel.getPersonIdByEmail(email);
                System.out.println("The account is happy");
                NewCookie loginCookie = new NewCookie("findmeLoggedIn", sessionValue);
                URI homepage = null;
                try {
                    homepage = new URI("/FindMe/connect/" + id + "/add");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                return Response.seeOther(homepage).cookie(loginCookie).build();
            }
        }
    }

    @GET
    @Path("/add")
    public Response connect(@PathParam("id") String id, @CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        String targetUserID = id;
        Map<String, Object> model = new HashMap<String, Object>();

        if(!id.equals(loginCookie.getValue())) {
            if (personModel.checkIfConnectionIsAlreadyPresent(loginCookie.getValue(), targetUserID)) {
                model.put("beenAdded", "false");
            } else {
                personModel.addPersonToStickerBook(loginCookie.getValue(), targetUserID);
                model.put("beenAdded", "true");
            }
        } else {
            model.put("beenAdded", "noSelfAdding");
        }

        model.put("isLoggedIn", "true");
        return Response.ok().entity(new Viewable("/connect.ftl", model)).build();
    }
}
