package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.model.PersonModel;
import uk.co.o2.findme.model.PersonsQuery;
import uk.co.o2.findme.model.SaltAndHashModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 19/05/15.
 */

@Path("/login")
public class LoginController {

    private PersonModel personModel = new PersonModel();
    private final SaltAndHashModel saltAndHashModel = FindMe.findme().saltAndHashModel;

    @GET
    public Response login(@CookieParam(value = "facewallLoggedIn") Cookie loginCookie) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
    }

    @POST
    public Response submitLogin(@FormParam("email") String email, @FormParam("password") String password) throws IOException, NoSuchAlgorithmException {

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
                return Response.ok().entity(new Viewable("/homepage.ftl")).build();
            }
        }
    }
}
