package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.PersonDAO;

import java.util.List;

public class DefaultSearchResultsModel implements SearchResultsModel {
    public List<PersonDAO> persons;

    public DefaultSearchResultsModel(List<PersonDAO> persons) {
        this.persons = persons;
    }
}