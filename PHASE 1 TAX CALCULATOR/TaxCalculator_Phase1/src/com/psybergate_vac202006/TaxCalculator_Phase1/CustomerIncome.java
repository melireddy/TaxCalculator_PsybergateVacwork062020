package com.psybergate_vac202006.TaxCalculator_Phase1;

import static com.psybergate_vac202006.TaxCalculator_Phase1.TaxConstants.*;

public class CustomerIncome {
	private double salary, bonus, interest, capGain;

    public CustomerIncome(double salary, double bonus, double interest, double capGain) {
        this.salary = salary;
        this.bonus = bonus;
        this.interest = interest;
        this.capGain = capGain;
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

    public double getSalary() {
        return salary;
    }
}
