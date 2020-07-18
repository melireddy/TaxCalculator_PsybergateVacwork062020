package psybergate_vac202006_tax_calculator_phase2;

import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.*;

public class CalculateTax {
	
	
	public static void main(String[]args)
	{
		CreateAllTables createAllTables = new CreateAllTables();
		createAllTables.createTablesForTax();
		CustomerDatabase customer = new CustomerDatabase();
		String name = "Jimmy";
		String surname = "Jones";
		customer.insertNewCustomer(name,surname);
		int id = customer.readCustomerID(name,surname);
		
		CustomerIncomeDatabase cIncome = new CustomerIncomeDatabase(url,user,password);
		cIncome.insertCustomerIncome(id,500000,25000,30000,100000);
		
		CustomerExpensesDatabase cExpenses = new CustomerExpensesDatabase();
		cExpenses.insertCustomerExpenses(id,150000, 40000, 10000);
		
		CalculateTaxPayable taxTable = new CalculateTaxPayable();
		
		double income = cIncome.calcTaxableIncome();
		double salary = cIncome.getSalary();
		double expense = cExpenses.calcTaxableExpenses(salary);
		double medCredit = cExpenses.getMedCredit();
		double taxableIncome = income - expense;
		double payable = taxTable.calcPayable(taxableIncome);
		double nettPayable = payable - medCredit - PRIMARY_REBATE;
		System.out.println(taxableIncome + "\n" + nettPayable);
		
		taxTable.insertTaxPayable(nettPayable, id);
		//System.out.println(id);
	}
}


