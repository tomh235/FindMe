package uk.co.o2.findme.controller;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.co.o2.findme.application.FindMe;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.PersonModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;

import javax.ws.rs.core.Response;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Path("/account")
public class AccountController {

    private final PersonModel personModel = FindMe.findme().personModel;

    @GET
    public Response getPerson(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {
        try {
            if (loginCookie == null || loginCookie.getValue().equals("null")) {
                return Response.ok().entity(new Viewable("/login.ftl")).build();
            } else {
                if (!personModel.isValidPersonID(loginCookie.getValue())) {
                    return Response.ok().entity(new Viewable("/login.ftl")).build();
                } else {
                    final String personID = loginCookie.getValue();
                    final PersonDAO person = personModel.getPersonById(personID);
                    final String numberOfStickers = personModel.getStickerBookNumber(loginCookie.getValue());
                    final boolean hasPlayed = personModel.getIfCompetedFor(loginCookie.getValue());
                    final String QRCodeLink = "https://ec2-52-11-9-103.us-west-2.compute.amazonaws.com:8443/FindMe/connect/" + loginCookie.getValue();
                    Map<String, Object> model = new HashMap();
                    model.put("person", person);
                    model.put("stickerCount", numberOfStickers);
                    model.put("hasPlayed", hasPlayed);
                    model.put("QRCodeLink", QRCodeLink);
                    return Response.ok().entity(new Viewable("/account.ftl", model)).build();
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

        final String personID = loginCookie.getValue();

        personModel.updatePersonDetails(personID, firstName, lastName, email, phoneNumber, picture, jobTitle, team, project, location, details, "Active");

        final PersonDAO person = personModel.getPersonById(personID);
        final String numberOfStickers = personModel.getStickerBookNumber(personID);
        final boolean hasPlayed = personModel.getIfCompetedFor(personID);
        Map<String, Object> model = new HashMap();
        model.put("person", person);
        model.put("stickerCount", numberOfStickers);
        model.put("hasPlayed", hasPlayed);
        return Response.ok().entity(new Viewable("/account.ftl", model)).build();
    }

    @GET
    @Path("/generate")
    public Response getQRCode(@CookieParam(value = "findmeLoggedIn") Cookie loginCookie) {

        ByteArrayOutputStream file = QRCode.from("http://localhost:9000/person/" + loginCookie.getValue()).to(ImageType.JPG).stream();


        Map<String, Object> model = new HashMap();
        model.put("qrcode", file);
        return Response.ok().entity(new Viewable("/qrcode.ftl", model)).build();
    }
}
