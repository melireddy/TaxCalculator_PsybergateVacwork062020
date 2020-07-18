package com.psybergate.vacwork202006.web.controller;

import com.psybergate.vacwork202006.dao.TaxTableDAO;
import com.psybergate.vacwork202006.domain.*;
import com.psybergate.vacwork202006.service.PersonService;
import com.psybergate.vacwork202006.service.TaxReturnService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxReturnController {
  private static final String CAPTURE_TAX_PAGE = "/WEB-INF/jsp/capture_tax_info.jsp";
  private static final String VIEW_TAX_PAGE = "/WEB-INF/jsp/view_tax_results.jsp";
  PersonIncome personIncome;
  PersonExpenses personExpenses;
  CalculateTax calculateTax;
  TaxTableDAO taxTableDAO;

  private TaxReturnService taxReturnService;

  public TaxReturnController() {
    taxReturnService = new TaxReturnService();
  }

  public String getCaptureTaxPage(HttpServletRequest request, HttpServletResponse response) {
    return CAPTURE_TAX_PAGE;
  }

  public String getViewTaxPage(HttpServletRequest request, HttpServletResponse response) {
    return VIEW_TAX_PAGE;
  }

  public String addTaxReturn(HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    TaxReturn taxReturn = getTaxReturnViewFromRequest(request);
    System.out.println(taxReturn);
    taxReturnService.saveTaxReturn(taxReturn);
    System.out.println("1");
    String indexURL = request.getContextPath();
    System.out.println("2");
    return indexURL;
  }


  private TaxReturn getTaxReturnViewFromRequest(HttpServletRequest request) {
    PersonService person = new PersonService();
    String test = request.getParameter("taxNumber");
    int length = test.length()-1;
    test = test.substring(0,length);
    Person newP = person.getPersonByTaxNumber(test);

    String taxYear = request.getParameter("taxyear");
    String salary = request.getParameter("salary");
    String retirement = request.getParameter("retirement");
    String interest = request.getParameter("interest");
    String allowance = request.getParameter("allowance");

    request.setAttribute("salary", salary);
    request.setAttribute("retirement", retirement);
    request.setAttribute("interest", interest);
    request.setAttribute("allowance", allowance);

    personIncome = new PersonIncome(Integer.parseInt(salary),Integer.parseInt(interest));
    personExpenses = new PersonExpenses(Integer.parseInt(retirement),Integer.parseInt(allowance));
    calculateTax = new CalculateTax();
    taxTableDAO = new TaxTableDAO();
    CalculateTax calcYear = taxTableDAO.findByTaxYear(Integer.parseInt(taxYear));

    double totalIncome =  personIncome.totalIncome();
    double totalExpense = personExpenses.totalExpenses(personIncome.getSalary());
    double taxableIncome = calcYear.getTaxableIncome(totalIncome,totalExpense);
    double taxPayable = calcYear.getTaxPayable();
    request.setAttribute("taxyear", taxYear);
    request.setAttribute("customer", newP);
    request.setAttribute("totalIncome", totalIncome);
    request.setAttribute("totalExpenses", totalExpense);
    request.setAttribute("taxableIncome", taxableIncome);
    request.setAttribute("taxPayable", taxPayable);

    TaxReturn taxReturn = new TaxReturn(Integer.parseInt(taxYear),newP,totalIncome,totalExpense,taxableIncome,taxPayable);

    return taxReturn;
  }

 /* private CalculateTax getCalculateTaxFromRequest(HttpServletRequest request) {
    String salary = request.getParameter("salary");
    String retirement = request.getParameter("retirement");
    String interest = request.getParameter("interest");
    String allowance = request.getParameter("allowance");

    request.setAttribute("salary", salary);
    request.setAttribute("retirement", retirement);
    request.setAttribute("interest", interest);
    request.setAttribute("allowance", allowance);

    personIncome = new PersonIncome(Integer.parseInt(salary),Integer.parseInt(interest));
    personExpenses = new PersonExpenses(Integer.parseInt(retirement),Integer.parseInt(allowance));
    calculateTax = new CalculateTax(Double.parseDouble(salary),Double.parseDouble(interest),Double.parseDouble(retirement),Double.parseDouble(allowance));
    return calculateTax;

  }*/

}
