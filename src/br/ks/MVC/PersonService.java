package br.ks.MVC;

import java.util.List;

public interface PersonService {

    List<Person> searchPersons(String searchString);
}
