package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.PreRegPerson;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.model.PersonModel;
import uk.co.o2.findme.model.RegistrationModel;
import uk.co.o2.findme.model.SaltAndHashModel;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response blankSignUpForm(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
            return Response.ok().entity(new Viewable("/registrationForm.ftl")).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response submitSignUpForm(@FormParam("firstName") String firstName,
                                     @FormParam("lastName") String lastName,
                                     @FormParam("email") String email,
                                     @FormParam("photo") String photo,
                                     @FormParam("phoneNumber") String phoneNumber,
                                     @FormParam("password") String password,
                                     @FormParam("team") String team,
                                     @FormParam("role") String jobTitle,
                                     @FormParam("details") String details,
                                     @FormParam("currentProject") String currentProject,
                                     @FormParam("location") String location) throws Exception {
        System.out.print("## " + photo + "\n");
        SaltAndHashDAO saltAndHashDAO = saltAndHashModel.createUserHash(password);
        PreRegPerson preRegPerson = new PreRegPerson(firstName, lastName, email, photo, phoneNumber, saltAndHashDAO.getSalt(), saltAndHashDAO.getPasswordHash(), jobTitle, location, currentProject, details, "Active", team);
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
            model.put("currentUser", firstName);
            model.put("hasPlayed", false);
            //String sessionValue = personModel.getEncryptedSessionId(email);
            String sessionValue = personModel.getPersonIdByEmail(email);
            NewCookie loginCookie = new NewCookie("findmeLoggedIn", sessionValue);
            Viewable existing = new Viewable("/successfulRegistration.ftl", model);
            Response.ResponseBuilder response = Response.ok().entity(existing).cookie(loginCookie);
            return response.build();

        }
    }
}
