package psybergate_vac202006_tax_calculator_phase2;

import java.sql.*;
import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.*;

public class CreateAllTables {
	
	
	public void createTablesForTax() {
		try{
				Connection connection = DriverManager.getConnection(url,user,password);
				Statement statement = connection.createStatement();
				
				String table = "CREATE TABLE IF NOT EXISTS Customer("
						+ "customerID SERIAL PRIMARY KEY,"
						+ "customerFirstName varchar(50),"
						+ "customerLastName varchar(50))";
				statement.executeUpdate(table);
		
				//ALTER TABLE customers_income ADD CONSTRAINT customer_income_id FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
				
				table = "CREATE TABLE IF NOT EXISTS CustomerIncome("
						+ "incomeID SERIAL PRIMARY KEY,"
						+ "customerID INTEGER,"
						+ "salary REAL NOT NULL,"
						+ "bonus REAL NOT NULL,"
						+ "interestReceived REAL NOT NULL,"
						+ "capitalGain REAL NOT NULL)";
				statement.executeUpdate(table);
				
				String drop = "ALTER TABLE CustomerIncome DROP CONSTRAINT IF EXISTS customerIncomeID";
				statement.executeUpdate(drop);
				
				String foreign = "ALTER TABLE CustomerIncome ADD CONSTRAINT customerIncomeID FOREIGN KEY(customerID) "+
				"REFERENCES Customer(customerID)";
				statement.executeUpdate(foreign);
				
				table = "CREATE TABLE IF NOT EXISTS CustomerExpenses("
						+ "ExpenseID SERIAL PRIMARY KEY,"
						+ "customerID INT,"
						+ "retirementFund REAL NOT NULL,"
						+ "travelAllowance REAL NOT NULL,"
						+ "medicalCredit REAL NOT NULL)";
				statement.executeUpdate(table);
				
				drop = "ALTER TABLE CustomerExpenses DROP CONSTRAINT IF EXISTS customerExpenseID";
				statement.executeUpdate(drop);
//				
				foreign = "ALTER TABLE CustomerExpenses ADD CONSTRAINT customerExpenseID FOREIGN KEY(customerID) "+
						"REFERENCES Customer(customerID)";
						statement.executeUpdate(foreign);				
				table = "CREATE TABLE IF NOT EXISTS CustomerNettPayable("
						+ "payableID SERIAL PRIMARY KEY,"
						+"customerID INT,"
						+ "nettPayable REAL NOT NULL)";
				statement.executeUpdate(table);
				
				drop = "ALTER TABLE CustomerNettPayable DROP CONSTRAINT IF EXISTS customerPayableID";
				statement.executeUpdate(drop);
				
				foreign = "ALTER TABLE CustomerNettPayable ADD CONSTRAINT customerPayableID FOREIGN KEY(customerID) "+
						"REFERENCES Customer(customerID)";
						statement.executeUpdate(foreign);
				
		}catch(SQLException e)
		{
			System.out.println("CreateAllTables Class\n"+e.getMessage());
		}
	}

}

