package com.hr.corp;

import gov.irs.TaxPayer;

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
