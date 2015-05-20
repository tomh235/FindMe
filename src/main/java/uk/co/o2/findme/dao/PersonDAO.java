package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class PersonDAO implements SearchResultsModel {

    // Fields
    private int personId;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private String areaCode;
    private String phoneNumber;
    private String jobTitle;
    private String skypeName;
    private String location;
    private String teamName;
    private String statusInTeam;

    public PersonDAO(int personId,
                     String firstName,
                     String lastName,
                     String picture,
                     String email,
                     String areaCode,
                     String phoneNumber,
                     String jobTitle,
                     String skypeName,
                     String location,
                     String teamName,
                     String statusInTeam) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.email = email;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.skypeName = skypeName;
        this.location = location;
        this.teamName = teamName;
        this.statusInTeam = statusInTeam;
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

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public String getLocation() {
        return location;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getStatusInTeam() {
        return statusInTeam;
    }
}

