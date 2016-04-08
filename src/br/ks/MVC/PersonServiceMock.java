package br.ks.MVC;

import java.util.ArrayList;
import java.util.List;

class PersonServiceMock implements PersonService {

    private List<Person> personDB;

    public PersonServiceMock() {
        personDB = new ArrayList<Person>();
        personDB.add(new Person(1, "Graham", "Parrish"));
        personDB.add(new Person(2, "Daniel", "Hendrix"));
        personDB.add(new Person(3, "Rachel", "Holman"));
        personDB.add(new Person(4, "Sarah", "Todd"));
        personDB.add(new Person(5, "Talon", "Wolf"));
        personDB.add(new Person(6, "Josephine", "Dunn"));
        personDB.add(new Person(7, "Benjamin", "Hebert"));
        personDB.add(new Person(8, "Lacota", "Browning "));
        personDB.add(new Person(9, "Sydney", "Ayers"));
        personDB.add(new Person(10, "Dustin", "Stephens"));
        personDB.add(new Person(11, "Cara", "Moss"));
        personDB.add(new Person(12, "Teegan", "Dillard"));
        personDB.add(new Person(13, "Dai", "Yates"));
        personDB.add(new Person(14, "Nora", "Garza"));
    }

    public List<Person> searchPersons(String searchString) {
        List<Person> matches = new ArrayList<Person>();

        if (searchString == null) {
            return matches;
        }

        for (Person person : personDB) {
            if (person.getFirstName().contains(searchString)
                    || person.getLastName().contains(searchString)) {
                matches.add(person);
            }

        }
        return matches;
    }

}
