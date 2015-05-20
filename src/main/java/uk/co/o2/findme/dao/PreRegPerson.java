package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class PreRegPerson implements SearchResultsModel {

    // Fields
    private int personId;
    private String firstName;
    private String lastName;
    private String email;
    private String salt;
    private String password;
    private String jobTitle;
    private String location;
    private String currentProject;
    private String teamName;

    public PreRegPerson(String firstName,
                        String lastName,
                        String email,
                        String salt,
                        String password,
                        String jobTitle,
                        String location,
                        String currentProject,
                        String teamName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.jobTitle = jobTitle;
        this.location = location;
        this.currentProject = currentProject;
        this.teamName = teamName;
    }


    // Getters

    public int getPersonId() {
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
}

