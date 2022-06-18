package com.hr.personnel;

import org.junit.Assert;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee kane;

    @Before
    public void setUp() throws Exception {
        kane = new Employee("kane", LocalDate.of(2005, 2, 3));
    }

    @org.junit.Test
    public void getEmployeeInfo() {
        String employeeInfo = kane.getEmployeeInfo();
        assertEquals("name = kane, hireDate = 2005-02-03", employeeInfo);
    }

    @org.junit.Test
    public void work() {
        String work = kane.work();
        assertEquals("kane worked", work);
    }
}