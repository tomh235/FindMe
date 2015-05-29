package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/account")
public class AccountController {

    PersonModel personModel = new PersonModel();

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                return Response.ok().entity(new Viewable("/login.ftl")).build();
            } else {
                if (!personModel.isValidPersonID(Integer.parseInt(loginCookie.getValue()))) {
                    return Response.ok().entity(new Viewable("/login.ftl")).build();
                } else {
                    final int personID = Integer.parseInt(loginCookie.getValue());
                    final PersonDAO person = personModel.getPersonById(personID);
                    return Response.ok().entity(new Viewable("/account.ftl", person)).build();
                }
            }
        } catch (NullPointerException e) {
            return Response.ok().entity(new Viewable("/login.ftl")).build();
        }
    }


    @POST
    public Response updateDetails(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie,
                              @FormParam("firstName") String firstName,
                            @FormParam("lastName") String lastName,
                            @FormParam("picture") String picture,
                            @FormParam("email") String email,
                            @FormParam("phoneNumber") String phoneNumber,
                            @FormParam("teamName") String team,
                            @FormParam("jobTitle") String jobTitle,
                            @FormParam("currentProject") String project,
                            @FormParam("location") String location,
                            @FormParam("details") String details) throws Exception {

        final int personID = Integer.parseInt(loginCookie.getValue());

        personModel.updatePersonDetails(personID, firstName, lastName, email, phoneNumber, picture, jobTitle, team, project, location, details, "Active");

        final PersonDAO person = personModel.getPersonById(personID);
        return Response.ok().entity(new Viewable("/account.ftl", person)).build();

    }
}
