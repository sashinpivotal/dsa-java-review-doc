package com.hr.corp;

import org.junit.Assert;
import org.junit.Test;

public class AuditorTest {

    @Test
    public void computeMonthlyProfit_should_return_correct_profit_value_given_valid_fixed_cost_and_tax_to_pay() {
        Auditor auditor = new Auditor();
        double monthlyProfit = auditor.computeMonthlyProfit(10000.0, 1000.0, 1000.0);
        Assert.assertEquals(8000.0, monthlyProfit, 0.01);
    }
}