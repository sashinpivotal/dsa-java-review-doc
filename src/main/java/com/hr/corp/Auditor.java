package com.hr.corp;

public class Auditor {

    public double performMonthlyAudit(double monthlyIncome,
                                             double monthlyFixedCost,
                                             double monthlyTaxToPay ) {
        return monthlyIncome - (monthlyFixedCost + monthlyTaxToPay);
    }
}
