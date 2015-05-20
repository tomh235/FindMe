package uk.co.o2.findme.application;


import uk.co.o2.findme.controller.OverviewController;
import uk.co.o2.findme.mapper.SearchResultsPersonModelMapper;
import uk.co.o2.findme.model.RegistrationModel;
import uk.co.o2.findme.model.SaltAndHashModel;
import uk.co.o2.findme.model.SearchModel;

final public class FindMe {

    private static FindMe findme = createFindMe();

    public final SearchModel searchModel;
    public final RegistrationModel registrationModel;
    public final SaltAndHashModel saltAndHashModel;


    private FindMe(
            SearchModel searchModel,
            RegistrationModel registrationModel,
            SaltAndHashModel saltAndHashModel
    ) {
        this.searchModel = searchModel;
        this.registrationModel = registrationModel;
        this.saltAndHashModel = saltAndHashModel;
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

        return new FindMe(searchModel, registrationModel, saltAndHashModel);
    }
}
