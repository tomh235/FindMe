package uk.co.o2.findme.application;


import uk.co.o2.findme.controller.OverviewController;
import uk.co.o2.findme.mapper.SearchResultsPersonModelMapper;
import uk.co.o2.findme.model.PersonModel;
import uk.co.o2.findme.model.RegistrationModel;
import uk.co.o2.findme.model.SaltAndHashModel;
import uk.co.o2.findme.model.SearchModel;

import java.io.InputStream;
import java.util.Properties;

final public class FindMe {

    private static FindMe findme = createFindMe();

    public final SearchModel searchModel;
    public final RegistrationModel registrationModel;
    public final SaltAndHashModel saltAndHashModel;
    public final PersonModel personModel;


    private FindMe(
            SearchModel searchModel,
            RegistrationModel registrationModel,
            SaltAndHashModel saltAndHashModel,
            PersonModel personModel
    ) {
        this.searchModel = searchModel;
        this.registrationModel = registrationModel;
        this.saltAndHashModel = saltAndHashModel;
        this.personModel = personModel;

    }

    public static FindMe findme() {
        return findme;
    }

    private static FindMe createFindMe() {



        SearchResultsPersonModelMapper searchResultsPersonModelMapper = new SearchResultsPersonModelMapper();

        SearchModel searchModel = new SearchModel(
          searchResultsPersonModelMapper
        );

        RegistrationModel registrationModel = new RegistrationModel();
        SaltAndHashModel saltAndHashModel = new SaltAndHashModel();
        PersonModel personModel = new PersonModel(searchResultsPersonModelMapper);

        return new FindMe(searchModel, registrationModel, saltAndHashModel, personModel);
    }
}
