package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class StickerBookPersonDAO implements SearchResultsModel {

    // Fields
    private int personId;
    private String firstName;
    private String lastName;
    private String picture;
    private String avatar;
    private boolean isStarPerson;
    private boolean isConnected;

    public StickerBookPersonDAO(int personId,
                                String firstName,
                                String lastName,
                                String picture,
                                String avatar,
                                boolean isStarPerson,
                                boolean isConnected) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.avatar = avatar;
        this.isStarPerson = isStarPerson;
        this.isConnected = isConnected;
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

    public String getAvatar() {
        return avatar;
    }

    public boolean getIsStarPerson() {
        return isStarPerson;
    }

    public boolean getIsConnected() {
        return isConnected;
    }
}

