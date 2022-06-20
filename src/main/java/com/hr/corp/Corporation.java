package com.hr.corp;

import gov.irs.TaxPayer;

import static gov.irs.TaxConstants.CORP_TAX_RATE;

public class Corporation implements TaxPayer {

    private String name;
    private double monthlyProfit;

    public Corporation(String name, double monthlyProfit) {
        this.name = name;
        this.monthlyProfit = monthlyProfit;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        return monthlyProfit * CORP_TAX_RATE;
    }
}
