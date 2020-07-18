package com.psybergate.vacwork202006.domain;

import static com.psybergate.vacwork202006.dao.TaxConstants.*;

public class PersonExpenses {
    private double retireFund, travelAllow;

    public PersonExpenses(double retireFund, double travelAllow) {
        this.retireFund = retireFund;
        this.travelAllow = travelAllow;
    }

    public double totalExpenses(double salary)
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
}
