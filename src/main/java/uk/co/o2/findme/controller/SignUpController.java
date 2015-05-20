package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PreRegPerson;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.model.RegistrationModel;
import uk.co.o2.findme.model.SaltAndHashModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/register")
public class SignUpController {

    private String errorStatus = "";
    private String happyStatus = "Happy days - you're registered! We hope to see you using the application when its up and running. You'll get a follow up email to tell you when that is :)";
    private String badEmail = "Ooops. It looks like that email address is already in use. Try another or check the spelling.";

    private final RegistrationModel registrationModel = FindMe.findme().registrationModel;
    private final SaltAndHashModel saltAndHashModel = FindMe.findme().saltAndHashModel;

    @GET
    public Response blankSignUpForm(@CookieParam(value = "facewallLoggedIn") Cookie loginCookie) {
            return Response.ok().entity(new Viewable("/registrationForm.ftl")).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response submitSignUpForm(@FormParam("firstName") String firstName,
                                     @FormParam("lastName") String lastName,
                                     @FormParam("email") String email,
                                     @FormParam("password") String password,
                                     @FormParam("team") String team,
                                     @FormParam("role") String jobTitle,
                                     @FormParam("currentProject") String currentProject,
                                     @FormParam("location") String location) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.print("## " + jobTitle + "\n");
        SaltAndHashDAO saltAndHashDAO = saltAndHashModel.createUserHash(password);
        PreRegPerson preRegPerson = new PreRegPerson(firstName, lastName, email, saltAndHashDAO.getSalt(), saltAndHashDAO.getPasswordHash(), jobTitle, location, currentProject, team);
        System.out.print(preRegPerson.getJobTitle());
        Map<String, Object> model = new HashMap();
        model.put("personInformation", preRegPerson);

        if(!registrationModel.registerAccount(preRegPerson)) {
            model.put("statusError", badEmail);
            model.put("statusIcon", false);
            Viewable existing = new Viewable("/registrationForm.ftl", model);
            Response.ResponseBuilder response = Response.ok().entity(existing);
            return response.build();
        } else {
            model.put("statusError", happyStatus);
            model.put("statusIcon", true);
            Viewable existing = new Viewable("/successfulRegistration.ftl", model);
            Response.ResponseBuilder response = Response.ok().entity(existing);
            return response.build();

        }
    }
}
