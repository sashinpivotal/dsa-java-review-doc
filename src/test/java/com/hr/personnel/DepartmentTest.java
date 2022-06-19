package com.hr.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() throws Exception {
        department = new Department("engineering", "building2");
        department.addEmployee(new SalariedEmployee("jon",
                LocalDate.of(2020, 1, 1),
                3000.0));
        department.addEmployee(new HourlyEmployee("mary",
                LocalDate.of(2010, 3, 12),
                200, 10.0));
    }

    @Test
    public void addEmployee_should_add_an_employee_correctly() {
        int currentIndex = department.getCurrentIndex();
        Assert.assertEquals(2, currentIndex);
    }

    @Test
    public void letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked_should_return_correct_number() {
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        Assert.assertEquals(2, numberOfEmployeesWhoWorked);
    }

    @Test
    public void computeDepartmentMonthlyTotalCompensation_should_return_correct_value() {
        double departmentMonthlyTotalCompensation = department.computeDepartmentMonthlyTotalCompensation();
        Assert.assertEquals(5000.0, departmentMonthlyTotalCompensation, 0.01);
    }
}