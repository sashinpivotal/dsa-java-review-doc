package com.hr.corp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CorporationTest {

    @Test
    public void computeMonthlyTaxToPay_computes_monthly_tax_correctly() {
        Corporation myCompany = new Corporation("myCompany", 1000000.0);
        double monthlyTaxToPay = myCompany.computeMonthlyTaxToPay();
        Assert.assertEquals(100000.0, monthlyTaxToPay, 0.01);
    }
}