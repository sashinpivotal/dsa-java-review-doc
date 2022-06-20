package com.hr.corp;

import gov.irs.TaxPayer;

import static gov.irs.TaxConstants.CORP_TAX_RATE;

public class Corporation implements TaxPayer {

    private String name;
    private double monthlyProfit;

    private Auditor auditor;

    public static final double MONTHLY_FIXED_COST = 10000.0;

    public Corporation(String name, double monthlyProfit) {
        this.name = name;
        this.monthlyProfit = monthlyProfit;
    }

    public Corporation(String name, double monthlyProfit, Auditor auditor) {
        this(name, monthlyProfit);
        this.auditor = auditor;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        return monthlyProfit * CORP_TAX_RATE;
    }

    public CompanyHealth performMonthlyAudit() {
        return auditor.performMonthlyAudit(monthlyProfit,
                MONTHLY_FIXED_COST,
                computeMonthlyTaxToPay());
    }

}
