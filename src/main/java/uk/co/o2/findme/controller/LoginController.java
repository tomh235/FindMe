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

/**
 * Created by ee on 19/05/15.
 */

@Path("/login")
public class LoginController {

    private final PersonModel personModel = FindMe.findme().personModel;
    private final SaltAndHashModel saltAndHashModel = FindMe.findme().saltAndHashModel;

    @GET
    public Response login(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) throws URISyntaxException {
        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                return Response.ok().entity(new Viewable("/login.ftl")).build();
            } else {
                if (!personModel.isValidPersonID(loginCookie.getValue())) {
                    return Response.ok().entity(new Viewable("/login.ftl")).build();
                } else {
                    return Response.seeOther(new URI("/FindMe")).build();
                }
            }
        } catch (NullPointerException e) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
        }
    }

    @POST
    public Response submitLogin(@FormParam("email") String email, @FormParam("password") String password) throws Exception {
        if (!personModel.isEmailAddressExistingForLogin(email)) {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("email", email);
            model.put("error", "Invalid email address or password.");
            Viewable failedLogin = new Viewable("/login.ftl", model);
            System.out.println("Failed on wrong email");
            return Response.ok().entity(failedLogin).build();
        } else {
            SaltAndHashDAO saltAndPassword = personModel.getSaltFor(email);
            if(!saltAndHashModel.generateHashAndValidate(saltAndPassword, password)) {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("email", email);
                model.put("error", "Invalid email address or password.");
                Viewable failedLogin = new Viewable("/login.ftl", model);
                System.out.println("Failed on wrong password");
                return Response.ok().entity(failedLogin).build();
            } else {
                //String sessionValue = personModel.getEncryptedSessionId(email);
                String sessionValue = personModel.getPersonIdByEmail(email);

                NewCookie loginCookie = new NewCookie("findmeLoggedIn", sessionValue, null, null, "FindMe Session Cookie", -1, true);
                URI homepage = null;
                try {
                    homepage = new URI("/FindMe");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                return Response.seeOther(homepage).cookie(loginCookie).build();
            }
        }
    }
}
