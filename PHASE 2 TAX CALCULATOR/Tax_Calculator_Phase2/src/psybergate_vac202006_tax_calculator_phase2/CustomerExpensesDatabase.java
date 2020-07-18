package psybergate_vac202006_tax_calculator_phase2;

import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.*;

import java.sql.*;

public class CustomerExpensesDatabase {
	private double retireFund, travelAllow, medCredit;
	
	public void displayCustomerExpenses() {
		String SQL = "SELECT * FROM CustomerExpenses;";
		try 
		{
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement statement = connection.createStatement();
			ResultSet arrayExpenses = statement.executeQuery(SQL);

			while(arrayExpenses.next())
			{
				int customerNumber = arrayExpenses.getInt("customerID");
				double customerRetireFund = arrayExpenses.getDouble("retirementFund");
				double customerTravelAllowance = arrayExpenses.getDouble("travelAllowance");
				double customerMedCred = arrayExpenses.getDouble("medicalCredit");
				
				System.out.println("\nThe customer's ID is " + customerNumber
						+ "\nThe customer's retirement fund is " + customerRetireFund
						+ "\nThe customer's travel allowance is " + customerTravelAllowance
						+ "\nThe customer's medical credit is " + customerMedCred);
			}
		}catch(SQLException e)
		{
			System.out.println("Customer Expenses Class\n" + e.getMessage());
		}
	}
	
	public void insertCustomerExpenses(int id,double retirementF, double travelAllow, double medCred) {
		String customerExpenses = "INSERT INTO CustomerExpenses(customerID,retirementFund,travelAllowance,medicalCredit)"
				+ "VALUES ("+ id+","+ retirementF+","+travelAllow+","+medCred+");";
		
		this.retireFund = retirementF;
		this.medCredit = medCred;
		this.travelAllow = travelAllow;
	
		try 
		{
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement statement = connection.createStatement();
			statement.executeUpdate(customerExpenses);
			
		}catch(SQLException e)
		{
			System.out.println("Customer Expenses Class\n"+e.getMessage());
		}
	}
	
	   public double calcTaxableExpenses(double salary)
	    {
	    	double expenses = 0;
	    	
	        if(retireFund > (salary * RETIRE_FUND_RATE)){
	            expenses = expenses + salary * RETIRE_FUND_RATE;
	        }
	        else{
	            expenses = expenses + retireFund;
	        }

	        if(travelAllow > TRAVEL_ALLOW_EXEMPTION){
	            expenses = expenses + (TRAVEL_ALLOW_EXEMPTION);
	        }
	        else{
	            expenses = expenses + travelAllow;
	        }
	        return expenses;
	    }

	    public double getMedCredit() {
	    	if(medCredit>12000)
	    	{
	    		medCredit = 12000;
	    	}
	        return medCredit;
	    }
}
