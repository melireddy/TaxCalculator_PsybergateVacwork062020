package com.psybergate_vac202006.TaxCalculator_Phase1;

import static com.psybergate_vac202006.TaxCalculator_Phase1.TaxConstants.*;

public class CustomerExpenses {
	private double retireFund, travelAllow, medCredit;

    public CustomerExpenses(double retireFund, double travelAllow,double medCredit) {
        this.retireFund = retireFund;
        this.travelAllow = travelAllow;
        this.medCredit = medCredit;
    }

    public double getCustomerExpenses(double salary)
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
        if(medCredit > MEDCREDIT_EXEMPTION) {
        	return medCredit = MEDCREDIT_EXEMPTION;
        }
        else {
        	return medCredit;
        }
    }
}
