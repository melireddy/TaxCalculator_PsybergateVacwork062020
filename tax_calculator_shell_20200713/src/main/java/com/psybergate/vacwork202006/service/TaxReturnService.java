package com.psybergate.vacwork202006.service;

import com.psybergate.vacwork202006.dao.TaxReturnDAO;
import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.domain.TaxReturn;

public class TaxReturnService {

  private TaxReturnDAO taxReturnDAO;

  public TaxReturnService() {
    taxReturnDAO = new TaxReturnDAO();
  }

  public void saveTaxReturn(final TaxReturn taxReturn) {
    // write this method
    taxReturnDAO.insertTaxReturn(taxReturn);
  }

  public TaxReturn getTaxReturn(Person taxPayer) {
    // write this method
    return taxReturnDAO.findByCustomer(taxPayer);
  }



}
