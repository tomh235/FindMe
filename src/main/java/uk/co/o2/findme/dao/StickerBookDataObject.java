package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class StickerBookDataObject implements SearchResultsModel {

    // Fields
    private int personId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int stickerbookScore;


    public StickerBookDataObject(int personId,
                          String firstName,
                          String lastName,
                          String jobTitle,
                          int stickerbookScore
    ) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.stickerbookScore = stickerbookScore;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public int getStickerbookScore() {
        return stickerbookScore;
    }
}

