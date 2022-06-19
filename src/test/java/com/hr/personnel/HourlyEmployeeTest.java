package com.hr.personnel;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class HourlyEmployeeTest {

    private HourlyEmployee jon;

    @Before
    public void setUp() throws Exception {
        jon = new HourlyEmployee("jon",
                LocalDate.of(2010, 2, 3),
                100, 10.0);
    }

    @Test
    public void computeMonthlyCompensation_should_return_correct_value() {
        double monthlyCompensation = jon.computeMonthlyCompensation();
        assertEquals(1000.0, monthlyCompensation, 0.1);
    }

    @org.junit.Test
    public void getEmployeeInfo_should_return_correct_value_given_a_valid_employee() {
        String employeeInfo = jon.getEmployeeInfo();
        assertEquals("name = jon, hireDate = 2010-02-03", employeeInfo);
    }

    @org.junit.Test
    public void work_should_return_valid_String() {
        String work = jon.work();
        assertEquals("jon worked", work);
    }

    @Test
    public void computeMonthlyTaxToPay_should_compute_monthly_tax_correctly() {
        double monthlyTaxToPay = jon.computeMonthlyTaxToPay();
        assertEquals(50.0, monthlyTaxToPay, 0.01);
    }

    @Test
    public void computeMonthlyTaxToPay_should_return_0_when_monthly_compensation_is_less_than_standard_deduction() {
        Employee mary = new HourlyEmployee("mary",
                LocalDate.of(2010, 2, 3),
                10, 10.0);
        double monthlyTaxToPay = mary.computeMonthlyTaxToPay();
        assertEquals(0.0, monthlyTaxToPay, 0.01);
    }

    @Test(expected = IllegalHourlyWageException.class)
    public void setHourlyRate_should_throw_IllegalArgumentException_when_hourly_rate_is_set_below_federal_minimum_wage() {
        Employee mary = new HourlyEmployee("mary",
                LocalDate.of(2010, 2, 3),
                10, 5.0);
    }
}