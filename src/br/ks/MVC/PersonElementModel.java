package br.ks.MVC;

public class PersonElementModel {

    private Person person;

    public PersonElementModel(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return person.getFirstName() + ", " + person.getLastName();
    }
}