package com.hr.corp;

public class Auditor {

    public CompanyHealth performMonthlyAudit(double monthlyProfit,
                                             double monthlyFixedCost,
                                             double monthlyTaxToPay ) {

        CompanyHealth companyHealth = CompanyHealth.OK;

        if (monthlyProfit > monthlyFixedCost + monthlyTaxToPay) {
            companyHealth = CompanyHealth.HEALTHY;
        } else if (monthlyProfit < monthlyFixedCost + monthlyTaxToPay) {
            companyHealth = CompanyHealth.SICK;
        }

        return companyHealth;
    }
}
