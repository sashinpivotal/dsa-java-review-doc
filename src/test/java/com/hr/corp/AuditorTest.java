package com.hr.corp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuditorTest {

    @Test
    public void performMonthlyAudit_should_return_correct_value_given_valid_argument_values() {
        Auditor auditor = new Auditor();
        double monthlyProfit = auditor.performMonthlyAudit(10000.0, 1000.0, 1000.0);
        Assert.assertEquals(8000.0, monthlyProfit, 0.01);
    }
}