package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class StickerBookPersonDAO implements SearchResultsModel {

    // Fields
    private String personId;
    private String firstName;
    private String lastName;
    private String picture;

    public StickerBookPersonDAO(String personId,
                                String firstName,
                                String lastName,
                                String picture) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }
}

