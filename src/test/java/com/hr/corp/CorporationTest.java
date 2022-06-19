package com.hr.corp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CorporationTest {

    @Test
    public void computeMonthlyTaxToPay_computes_monthly_tax_correctly() {
        Corporation myCompany = new Corporation("myCompany", 1000000.0);
        double monthlyTaxToPay = myCompany.computeMonthlyTaxToPay();
        assertEquals(100000.0, monthlyTaxToPay, 0.01);
    }
}