package com.psybergate.vacwork202006.domain;

import static com.psybergate.vacwork202006.dao.TaxConstants.*;

public class PersonIncome {
    private double salary, interest;

    public PersonIncome(double salary, double interest) {
        this.salary = salary;
        this.interest = interest;
    }

     public double totalIncome(){
        double taxincome = salary;

        if(interest > INTEREST_EXEMPTION){
            taxincome = taxincome + (interest - INTEREST_EXEMPTION) ;
        }
        else{
            taxincome = taxincome + interest;
        }

        return taxincome;
    }

    public double getSalary() {
        return salary;
    }
}
