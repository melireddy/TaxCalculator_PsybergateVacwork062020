package com.psybergate.vacwork202006.dao;

import com.psybergate.vacwork202006.domain.CalculateTax;
import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.domain.PersonNotFoundException;
import com.psybergate.vacwork202006.domain.TaxReturn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaxTableDAO {

  private static final String URL = "jdbc:postgresql://localhost:5432/vacation_work";

  private static final String USERNAME = "postgres";

  private static final String PASSWORD = "1234";

  public TaxTableDAO() {
    try {
      Class.forName("org.postgresql.Driver");
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public CalculateTax findByTaxYear(final int taxYear) {
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      String selectSql = "select * from taxtable where taxyear = ?;";
      try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
        ps.setInt(1, taxYear);
        try (ResultSet rs = ps.executeQuery()) {
          if (rs.next()) {
            CalculateTax calculateTax = new CalculateTax();
            calculateTax.setPrimaryRebate(rs.getDouble("primary_rebate"));
            double taxDiff1 = rs.getDouble("tax_diff1");
            double taxDiff2 = rs.getDouble("tax_diff2");
            double taxDiff3 = rs.getDouble("tax_diff3");
            double taxDiff4 = rs.getDouble("tax_diff4");
            double taxDiff5 = rs.getDouble("tax_diff5");
            double taxDiff6 = rs.getDouble("tax_diff6");
            calculateTax.setTaxBrackets(taxDiff1, taxDiff2, taxDiff3, taxDiff4, taxDiff5, taxDiff6);
            return calculateTax;
          }
          else
            throw new PersonNotFoundException(
                    "Year = " + taxYear + " does not exist.");
        }
      }
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
