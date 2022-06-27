package com.hr.corp;

import gov.irs.TaxPayer;

import static com.hr.corp.CorporationConstants.MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY;
import static com.hr.corp.CorporationConstants.MINIMUM_PROFIT_TO_MAKE_TO_BE_OK;
import static gov.irs.TaxConstants.CORP_TAX_RATE;

public class Corporation implements TaxPayer {

    private String name;
    private double monthlyIncome;

    // Delegate auditing to an auditor
    private Auditor auditor;

    public static final double MONTHLY_FIXED_COST = 10000.0;

    public Corporation(String name, double monthlyIncome) {
        this.name = name;
        this.monthlyIncome = monthlyIncome;
    }

    public Corporation(String name, double monthlyIncome, Auditor auditor) {
        this(name, monthlyIncome);
        this.auditor = auditor;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        return monthlyIncome * CORP_TAX_RATE;
    }

    public CompanyHealth performMonthlyAudit() {

        double monthlyProfit
                = auditor.computeMonthlyProfit(monthlyIncome, MONTHLY_FIXED_COST, computeMonthlyTaxToPay());

        CompanyHealth companyHealth = CompanyHealth.SICK;

        if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY) {
            companyHealth = CompanyHealth.HEALTHY;
        } else if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_OK) {
            companyHealth = CompanyHealth.OK;
        }

        return companyHealth;

    }

}
