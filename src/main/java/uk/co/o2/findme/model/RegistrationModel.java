package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.PreRegPerson;

/**
 * Created by ee on 13/05/15.
 */
public class RegistrationModel {

    PersonsQuery personsQuery = new PersonsQuery();
    RegistrationQuery registrationQuery = new RegistrationQuery();

    public RegistrationModel() {

    }

    public boolean registerAccount(PreRegPerson preRegPerson) {
        if(!isEmailMatching(preRegPerson.getEmail())) {
            registrationQuery.registerUser(preRegPerson);
            System.out.println(preRegPerson.getPersonId());
            registrationQuery.setupGameData(preRegPerson.getPersonId());
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public boolean isEmailMatching(String email) {
        int numberOfRows = personsQuery.emailMatchCheck(email);
        if(numberOfRows != 0) {
            return true;
        } else {
            return false;
        }

    }
}
