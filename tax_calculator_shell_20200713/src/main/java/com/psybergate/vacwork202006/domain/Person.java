package com.psybergate.vacwork202006.domain;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Person {

  private String taxNumber; // unique business key

  private String name;

  private String surname;

  private LocalDate dateOfBirth;

  public Person() {
  }

  public Person(String taxNumber, String name, String surname, LocalDate dateOfBirth) {
    super();
    this.taxNumber = taxNumber;
    this.name = name;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
  }

  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

}
