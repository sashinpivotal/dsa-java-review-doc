package com.hr.corp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuditorTest  {

    private Auditor auditor;

    @Before
    public void setUp() throws Exception {
        auditor = new Auditor();
    }

    @Test
    public void performMonthlyAudit_should_return_HEALTHY_when_profit_is_lager_than_total_expense() {
        CompanyHealth companyHealth
                = auditor.performMonthlyAudit(10000.0, 3000.0, 2000.0);
        Assert.assertEquals(CompanyHealth.HEALTHY, companyHealth);
    }

    @Test
    public void performMonthlyAudit_should_return_SICK_when_profit_is_less_than_total_expense() {
        CompanyHealth companyHealth
                = auditor.performMonthlyAudit(1000.0, 3000.0, 2000.0);
        Assert.assertEquals(CompanyHealth.SICK, companyHealth);
    }
}