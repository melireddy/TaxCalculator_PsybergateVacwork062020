package com.psybergate.vacwork202006.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.service.PersonService;

public class PersonController {

  private static final String REGISTER_PAGE = "/WEB-INF/jsp/register.jsp";

  private PersonService personService;

  public PersonController() {
    personService = new PersonService();
  }

  public String getRegisterPage(HttpServletRequest request, HttpServletResponse response) {
    return REGISTER_PAGE;
  }

  public String registerPerson(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Person person = getPersonFromRequest(request);
    personService.registerPerson(person);
    String indexURL = request.getContextPath();
    return indexURL;
  }

  public Person getPersonFromRequest(HttpServletRequest request) {
    String taxNumber = request.getParameter("taxNumber");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
    request.setAttribute("taxNumber", taxNumber);
    request.setAttribute("name", name);
    request.setAttribute("surname", surname);
    request.setAttribute("dateOfBirth", dateOfBirth.toString());

    Person taxPayer = new Person(taxNumber, name, surname, dateOfBirth);
    return taxPayer;
  }

  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }
}
