package uk.co.o2.findme.mapper;


import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.model.DefaultSearchResultsModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPersonModelMapper {
    public DefaultSearchResultsModel map(List<PersonDAO> personsList) {

        List<PersonDAO> personSearchResultsList = new ArrayList<PersonDAO>();

        for (PersonDAO person : personsList) {
            personSearchResultsList.add(PersonSearchResultMapper.map(person));
        }

        return new DefaultSearchResultsModel(personSearchResultsList);
    }

    private static class PersonSearchResultMapper {
        public static PersonDAO map(PersonDAO person) {
            return person;
        }
    }
}
