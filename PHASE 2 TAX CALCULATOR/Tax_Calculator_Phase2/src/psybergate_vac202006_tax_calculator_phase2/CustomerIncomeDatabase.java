package psybergate_vac202006_tax_calculator_phase2;

import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.CAPITAL_GAIN_EXEMPTION;
import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.CAPITAL_GAIN_RATE;
import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.INTEREST_EXEMPTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerIncomeDatabase {
	private String url, username,pass;
	private double salary, bonus, interest, capGain;
	
	public CustomerIncomeDatabase(String url, String user, String password) {
		this.url = url;
		this.username = user;
		this.pass = password;
	}
	
	public void displayCustomerIncome() {
		String SQL = "SELECT * FROM CustomerIncome";
		try 
		{
			Connection connection = DriverManager.getConnection(url,username,pass);
			Statement statement = connection.createStatement();
			ResultSet arrayIncome = statement.executeQuery(SQL);

			while(arrayIncome.next())
			{
				int customerNumber = arrayIncome.getInt("customerID");
				double customerSalary = arrayIncome.getDouble("salary");
				double customerBonus = arrayIncome.getDouble("bonus");
				double customerInterest = arrayIncome.getDouble("interestReceived");
				double customerCapGain = arrayIncome.getDouble("capitalGain");
				System.out.println("\nThe customer's ID is " + customerNumber
						+ "\nThe customer's salary is " + customerSalary
						+ "\nThe customer's bonus is " + customerBonus
						+ "\nThe customer's interest received is " + customerInterest
						+ "\nThe customer's capital gain is " + customerCapGain);
			}
			
		}catch(SQLException e)
		{
			System.out.println("Customer Income Class\n" + e.getMessage());
		}
	}
	
	 public double calcTaxableIncome(){
	        double taxincome = salary + bonus;

	        if(interest > INTEREST_EXEMPTION){
	            taxincome = taxincome + (interest - INTEREST_EXEMPTION) ;
	        }

	        if(capGain > CAPITAL_GAIN_EXEMPTION){
	            taxincome = taxincome + (capGain - CAPITAL_GAIN_EXEMPTION) * CAPITAL_GAIN_RATE;
	        }

	        return taxincome;
	    }
	 
	public void insertCustomerIncome(int id,double salary, double bonus, double interest, double capGain) {
		String customerIncome = "INSERT INTO CustomerIncome(customerID,salary,bonus,interestReceived,capitalGain)"
				+ "VALUES ("+id+","+salary+","+bonus+","+interest+","+capGain+");";
		
		this.salary = salary;
		this.bonus = bonus;
		this.interest = interest;
		this.capGain = capGain;
		
		try 
		{
			Connection connection = DriverManager.getConnection(url,username,pass);
			Statement statement = connection.createStatement();
			statement.executeUpdate(customerIncome);
			
		}catch(SQLException e)
		{
			System.out.println("Customer Income Class\n"+e.getMessage());
		}
	}
	
    public double getSalary() {
        return salary;
    }
}
