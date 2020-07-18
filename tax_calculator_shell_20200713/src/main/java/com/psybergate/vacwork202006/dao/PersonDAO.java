package com.psybergate.vacwork202006.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.domain.PersonNotFoundException;

public class PersonDAO {

  private static final String URL = "jdbc:postgresql://localhost:5432/vacation_work";

  private static final String USERNAME = "postgres";

  private static final String PASSWORD = "1234";

  public PersonDAO() {
    try {
      Class.forName("org.postgresql.Driver");
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public void save(Person person) {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      String insertSql = "insert into person(taxnumber, name, surname, date_of_birth) values(?,?,?,?);";
      try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
        ps.setString(1, person.getTaxNumber());
        ps.setString(2, person.getName());
        ps.setString(3, person.getSurname());
        ps.setObject(4, person.getDateOfBirth());
        ps.execute();
      }
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public Person findByTaxNumber(final String taxNumber) {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      String selectSql = "select * from person where taxnumber = ?;";
      try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
        ps.setString(1, taxNumber);
        try (ResultSet rs = ps.executeQuery()) {
          if (rs.next()) {
            Person person = new Person();
            person.setTaxNumber(rs.getString("taxnumber"));
            person.setName(rs.getString("name"));
            person.setSurname(rs.getString("surname"));
            person.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

            return person;
          }
          else
            throw new PersonNotFoundException(
                "Person with taxnumber = " + taxNumber + " does not exist.");
        }
      }
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public List<Person> findAll() {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      List<Person> people = new ArrayList<>();
      String sql = "select * from Person;";
      try (Statement statement = connection.createStatement()) {
        try (ResultSet rs = statement.executeQuery(sql)) {
          while (rs.next()) {
            Person person = new Person(rs.getString("taxnumber"), rs.getString("name"),
                rs.getString("surname"), rs.getDate("date_of_birth").toLocalDate());
            people.add(person);
          }
          return people;
        }
      }
    }
    catch (Exception ex) {
      throw new RuntimeException("Something went wrong: ", ex);
    }
  }

}
