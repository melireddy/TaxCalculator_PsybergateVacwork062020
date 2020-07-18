package psybergate_vac202006_tax_calculator_phase2;

import java.sql.*;
import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.*;

public class CustomerDatabase {
	
	public void displayCustomers() {
		String SQL = "SELECT * FROM Customer";
		try 
		{
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(SQL);

			while(result.next())
			{
				int customerNumber = result.getInt("customerID");
				String customerFirstName = result.getString("customerFirstName");
				String customerLastName = result.getString("customerLastName");
				System.out.println("The customer's ID is " + customerNumber
						+ "\nThe customer's first name is " + customerFirstName
						+ "\nThe customer's surname is " + customerLastName);
			}
			
		}catch(SQLException e)
		{
			System.out.println("Customer Class\n" + e.getMessage());
		}
	}
	
	public void insertNewCustomer(String name, String surname) {
		String customerDetails = "INSERT INTO Customer(customerFirstName,customerLastName)"
				+ "VALUES ('"+name+"', '"+surname+"');";
		
		try 
		{
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement statement = connection.createStatement();
			
			statement.execute(customerDetails);
		}catch(SQLException e)
		{
			System.out.println("Customer Class\n"+e.getMessage());
		}
	}
	
	public int readCustomerID(String name, String surname) {
		String customerDetails = "SELECT customerID FROM Customer WHERE customerFirstName ='"+name+"' AND customerLastName ='"+surname+"' ;";
		int id = 0;
		try 
		{
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(customerDetails);
			
			while(result.next())
			{
				id = result.getInt("customerID");
				
			}
		}catch(SQLException e)
		{
			System.out.println("Customer Class\n"+e.getMessage());
		}
		
		return id;
	}
}
