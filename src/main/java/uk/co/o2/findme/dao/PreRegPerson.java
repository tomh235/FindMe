package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class PreRegPerson implements SearchResultsModel {

    // Fields
    private String personId;
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private String phoneNumber;
    private String salt;
    private String password;
    private String jobTitle;
    private String currentProject;
    private String location;
    private String details;
    private String status;
    private String teamName;

    public PreRegPerson(String personId,
                        String firstName,
                        String lastName,
                        String email,
                        String photo,
                        String phoneNumber,
                        String salt,
                        String password,
                        String jobTitle,
                        String location,
                        String currentProject,
                        String details,
                        String status,
                        String teamName)
    {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.jobTitle = jobTitle;
        this.location = location;
        this.currentProject = currentProject;
        this.details = details;
        this.status = status;
        this.teamName = teamName;
    }


    // Getters

    public String getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }
}

