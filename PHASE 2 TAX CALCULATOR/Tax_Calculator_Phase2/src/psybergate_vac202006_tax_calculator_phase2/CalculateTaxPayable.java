package psybergate_vac202006_tax_calculator_phase2;
import static psybergate_vac202006_tax_calculator_phase2.TaxConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculateTaxPayable {
	public double checkIncome(double low, double high, double income){
        if(income <= (high - low)){
            return income;
        }
        else{
            return (high - low);
        }
    }

    public double calcPayable(double taxIncome){
        double tax = 0;
        double payable = 0;
        double newIncome = 0;
        if((taxIncome >= 0)&&(taxIncome <= 205900)){
             tax = checkIncome(0,205900,taxIncome);
             payable = tax * TAX_RATE1;
        }
        else if((taxIncome >= 205901)&&(taxIncome <= 321600)) {
            newIncome = taxIncome  - TAX_DIFF1;
            System.out.println(newIncome);
            tax = checkIncome(205901,321600, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + tax * TAX_RATE2;

        }
        else if((taxIncome >= 321601)&&(taxIncome <= 445100)){
            newIncome = taxIncome - (TAX_DIFF1) - (TAX_DIFF2 );
            tax = checkIncome(321601,445100, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + (TAX_RATE2 * TAX_DIFF2) + tax * TAX_RATE3;
        }
        else if((taxIncome >= 445101)&&(taxIncome <= 584200)){
            newIncome = taxIncome - (TAX_DIFF1) - (TAX_DIFF2) - (TAX_DIFF3);
            tax = checkIncome(445101,584200, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + (TAX_RATE2 * TAX_DIFF2) + (TAX_RATE3 * TAX_DIFF3)+ tax * TAX_RATE4;
        }
        else if((taxIncome >= 584201)&&(taxIncome <= 744800)){
            newIncome = taxIncome - (TAX_DIFF1) - (TAX_DIFF2) - (TAX_DIFF3 ) - (TAX_DIFF4 );
            tax = checkIncome(584201,744800, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + (TAX_RATE2 * TAX_DIFF2)
                    + (TAX_RATE3 * TAX_DIFF3) + (TAX_RATE4 * TAX_DIFF4)+ tax * TAX_RATE5;
        }
        else if((taxIncome >= 744801)&&(taxIncome <= 1577300)){
            newIncome = taxIncome - (TAX_DIFF1) - (TAX_DIFF2)
                    - (TAX_DIFF3 ) - (TAX_DIFF4 ) - (TAX_DIFF5);
            tax = checkIncome(744801,1577300, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + (TAX_RATE2 * TAX_DIFF2)
                    + (TAX_RATE3 * TAX_DIFF3) + (TAX_RATE4 * TAX_DIFF4) + (TAX_DIFF5 * TAX_RATE5)+ tax * TAX_RATE6;
        }
        else if((taxIncome >= 1577301)&&(taxIncome <= 1000000000)){
            newIncome = taxIncome - (TAX_DIFF1 ) - (TAX_DIFF2)
                    - (TAX_DIFF3) - (TAX_DIFF4 ) - (TAX_DIFF5 ) - (TAX_DIFF6 );
            tax = checkIncome(1577301,1000000000, newIncome);
            payable = (TAX_RATE1 * TAX_DIFF1) + (TAX_RATE2 * TAX_DIFF2)
                    + (TAX_RATE3 * TAX_DIFF3) + (TAX_RATE4 * TAX_DIFF4)
                    + (TAX_DIFF5 * TAX_RATE5)+(TAX_DIFF6 * TAX_RATE6)+ tax * TAX_RATE7;
        }
        return payable;
    }
    
    public void insertTaxPayable(double nettPayable, int id) {
    	String customerDetails = "INSERT INTO customernettpayable(customerid,nettpayable)"
				+ "VALUES ("+id+", "+nettPayable+");";
		
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
}
