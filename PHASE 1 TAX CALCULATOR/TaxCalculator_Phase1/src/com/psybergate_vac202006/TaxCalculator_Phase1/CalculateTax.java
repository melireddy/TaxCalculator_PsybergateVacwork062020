package com.psybergate_vac202006.TaxCalculator_Phase1;

import static com.psybergate_vac202006.TaxCalculator_Phase1.TaxConstants.*;

public class CalculateTax {

	public static void main(String[] args){
        CustomerIncome customerIncome = new CustomerIncome(500000,25000,30000,100000);
        CalculateTaxPayable taxTable = new CalculateTaxPayable();
        CustomerExpenses customerExpense = new CustomerExpenses(150000, 40000, 10000);
        
        double income = customerIncome.calcTaxableIncome();
        double salary = customerIncome.getSalary();
        double expense = customerExpense.getCustomerExpenses(salary);
        double medCredit = customerExpense.getMedCredit();
        double taxableIncome = income - expense;
        double payable = taxTable.calcPayable(taxableIncome);
        double nettPayable = payable - medCredit - PRIMARY_REBATE;
        
        System.out.println("Taxable Income: R " + taxableIncome);
        System.out.println("Tax Payable: R " + payable);
        System.out.println("Nett Tax Payable: R " + nettPayable);
    }
}

