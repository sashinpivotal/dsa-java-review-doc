package com.hr.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee mary;

    @Before
    public void setUp() throws Exception {
        mary = new SalariedEmployee("mary",
                LocalDate.of(2001, 3, 4),
                2000.0);
    }

    @Test
    public void computeMonthlyCompensation_should_return_correct_value() {
        double monthlyCompensation = mary.computeMonthlyCompensation();
        Assert.assertEquals(2000.0, monthlyCompensation, 0.1);
    }

}