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
        department.addEmployee(new Employee("jon", LocalDate.of(2020,1,1)));
        department.addEmployee(new Employee("kane", LocalDate.of(2015,3,2)));
    }

    @Test
    public void addEmployee_should_add_an_employee_correctly() {
        int currentIndex = department.getCurrentIndex();
        Assert.assertEquals(2, currentIndex);
    }

    @Test
    public void letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        Assert.assertEquals(2, numberOfEmployeesWhoWorked);
    }
}