package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.mapper.SearchResultsPersonModelMapper;

import java.util.List;

/**
 * Created by ee on 13/05/15.
 */
public class SearchModel {

    PersonsQuery personsQuery = new PersonsQuery();
    SearchResultsPersonModelMapper searchResultsModelMapper;

    public SearchModel(SearchResultsPersonModelMapper searchResultsModelMapper) {
        this.searchResultsModelMapper = searchResultsModelMapper;
    }

    public SearchResultsModel search(String nameSearch) {
        SearchResultsModel resultsModel;
        List<PersonDAO> personList = personsQuery.searchByPersonNameOf(nameSearch);
        resultsModel = searchResultsModelMapper.map(personList);
        return resultsModel;
    }
}
