package com.hr.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

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
        Assert.assertEquals(1000.0, monthlyCompensation, 0.1);
    }

    @org.junit.Test
    public void getEmployeeInfo_should_return_correct_value_given_a_valid_employee() {
        String employeeInfo = jon.getEmployeeInfo();
        assertEquals("name = jon, hireDate = 2010-02-03", employeeInfo);getEmployeeInfo_should_return_correct_value_given_a_valid_employee();
    }

    @org.junit.Test
    public void work_should_return_valid_String() {
        String work = jon.work();
        assertEquals("jon worked", work);
    }
}