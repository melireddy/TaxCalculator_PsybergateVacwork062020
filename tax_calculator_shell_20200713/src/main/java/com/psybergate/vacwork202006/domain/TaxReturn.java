package com.psybergate.vacwork202006.domain;

import java.time.LocalDate;

public class TaxReturn {

  private int taxYear;

  private Person customer;

  private double totalIncome;

  private double totalExpenses;

  private double taxableIncome;

  private double taxPayable;

  public TaxReturn() {
    this.taxYear = LocalDate.now().getYear();
  }

  public TaxReturn(final int taxYear, final Person customer, final double totalIncome,
      final double totalExpenses, final double taxableIncome, final double taxPayable) {
    super();
    this.taxYear = taxYear;
    this.customer = customer;
    this.totalIncome = totalIncome;
    this.totalExpenses = totalExpenses;
    this.taxableIncome = taxableIncome;
    this.taxPayable = taxPayable;
  }

  public int getTaxYear() {
    return taxYear;
  }

  public void setTaxYear(int taxYear) {
    this.taxYear = taxYear;
  }

  public Person getCustomer() {
    return customer;
  }

  public void setCustomer(Person customer) {
    this.customer = customer;
  }

  public double getTotalIncome() {
    return totalIncome;
  }

  public void setTotalIncome(double totalIncome) {
    this.totalIncome = totalIncome;
  }

  public double getTotalExpenses() {
    return totalExpenses;
  }

  public void setTotalExpenses(double totalExpenses) {
    this.totalExpenses = totalExpenses;
  }

  public double getTaxableIncome() {
    return taxableIncome;
  }

  public void setTaxableIncome(double taxableIncome) {
    this.taxableIncome = taxableIncome;
  }

  public double getTaxPayable() {
    return taxPayable;
  }

  public void setTaxPayable(double taxPayable) {
    this.taxPayable = taxPayable;
  }

}
