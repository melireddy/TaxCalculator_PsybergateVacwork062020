package com.psybergate.vacwork202006.domain;

import static com.psybergate.vacwork202006.dao.TaxConstants.*;

public class CalculateTax {
    private double taxIncome;
    private double TAX_DIFF1;
    private double TAX_DIFF2;
    private double TAX_DIFF3;
    private double TAX_DIFF4;
    private double TAX_DIFF5;
    private double TAX_DIFF6;
    private double PRIMARY_REBATE;

    public CalculateTax(){

    }

    public void setPrimaryRebate(double rebate){
        PRIMARY_REBATE = rebate;
    }

    public void setTaxBrackets(double taxDiff1,double taxDiff2,double taxDiff3,double taxDiff4,double taxDiff5,double taxDiff6){
        TAX_DIFF1 = taxDiff1;
        TAX_DIFF2 = taxDiff2;
        TAX_DIFF3 = taxDiff3;
        TAX_DIFF4 = taxDiff4;
        TAX_DIFF5 = taxDiff5;
        TAX_DIFF6 = taxDiff6;
    }
    public double getTaxableIncome(double income, double expenses){
        return taxIncome = income - expenses;
    }

    public double checkIncome(double low, double high, double income){
        if(income <= (high - low)){
            return income;
        }
        else{
            return (high - low);
        }
    }

    public double getTaxPayable(){
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
        return payable - PRIMARY_REBATE; // look at tax table

    }
}
