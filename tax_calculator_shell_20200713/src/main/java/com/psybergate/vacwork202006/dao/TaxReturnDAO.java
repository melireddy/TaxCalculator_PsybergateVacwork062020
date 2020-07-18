package com.psybergate.vacwork202006.dao;

import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.domain.PersonNotFoundException;
import com.psybergate.vacwork202006.domain.TaxReturn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaxReturnDAO {

  private static final String URL = "jdbc:postgresql://localhost:5432/vacation_work";

  private static final String USERNAME = "postgres";

  private static final String PASSWORD = "1234";

  public TaxReturnDAO() {
    try {
      Class.forName("org.postgresql.Driver");
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public void insertTaxReturn(TaxReturn taxReturn) {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      String insertSql = "insert into taxreturn(taxyear,customer,totalincome,totalexpenses,taxableincome,taxpayable) values(?,?,?,?,?,?);";
      System.out.println("here");
      try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
        ps.setInt(1, taxReturn.getTaxYear());
        System.out.println(taxReturn.getCustomer().getTaxNumber());
        ps.setString(2, String.valueOf(taxReturn.getCustomer().getTaxNumber()));
        ps.setDouble(3, taxReturn.getTotalIncome());
        ps.setDouble(4, taxReturn.getTotalExpenses());
        ps.setDouble(5, taxReturn.getTaxableIncome());
        ps.setDouble(6, taxReturn.getTaxPayable());
        ps.execute();
      }
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public TaxReturn findByCustomer(final Person customer) {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      String selectSql = "select * from taxreturn where customer = ?;";
      try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
        ps.setObject(1, customer);
        try (ResultSet rs = ps.executeQuery()) {
          if (rs.next()) {  //customer to person SQL + JAVA
            TaxReturn taxReturn = new TaxReturn();
            String rPayer = rs.getString("customer");
            Person person = new Person();
            person.setTaxNumber(rPayer);
            taxReturn.setCustomer(person);
            //taxReturn.setCustomer(customer);
            taxReturn.setTaxYear(rs.getInt("taxyear"));
            taxReturn.setTotalIncome(rs.getDouble("totalincome"));
            taxReturn.setTotalExpenses(rs.getDouble("totalexpenses"));
            taxReturn.setTaxableIncome(rs.getDouble("taxableincome"));
            taxReturn.setTaxPayable(rs.getDouble("taxpayable"));

            return taxReturn;
          }
          else
            throw new PersonNotFoundException(
                    "Person with taxnumber = " + customer + " does not exist.");
        }
      }
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
