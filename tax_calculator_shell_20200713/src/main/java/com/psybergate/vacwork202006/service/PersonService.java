package com.psybergate.vacwork202006.service;

import java.util.List;

import com.psybergate.vacwork202006.dao.PersonDAO;
import com.psybergate.vacwork202006.domain.Person;

public class PersonService {

  private PersonDAO personDAO;

  public PersonService() {
    personDAO = new PersonDAO();
  }

  public void registerPerson(Person newPerson) {
    personDAO.save(newPerson);
  }

  public Person getPersonByTaxNumber(final String taxNumber) {
    return personDAO.findByTaxNumber(taxNumber);
  }

  public List<Person> getAllPeople() {
    return personDAO.findAll();
  }

}
