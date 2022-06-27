package com.hr.corp;

public class Auditor {

    public double computeMonthlyProfit(double monthlyIncome,
                                       double monthlyFixedCost,
                                       double monthlyTaxToPay ) {
        return monthlyIncome - (monthlyFixedCost + monthlyTaxToPay);
    }
}
