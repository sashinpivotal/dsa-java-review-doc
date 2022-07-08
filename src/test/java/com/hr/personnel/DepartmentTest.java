package com.hr.personnel;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {

    private Department department;
    private DepartmentDAO departmentDAO;

    @Before
    public void setUp() throws Exception {
        department = new Department("engineering", "building2", new DepartmentDAO());
        departmentDAO = department.getDepartmentDAO();
        departmentDAO.addEmployee(new SalariedEmployee("jon",
                LocalDate.of(2020, 1, 1),
                3000.0));
        departmentDAO.addEmployee(new HourlyEmployee("mary",
                LocalDate.of(2010, 3, 12),
                200, 10.0));
    }

    @Test
    public void addEmployee_should_add_an_employee_correctly() {
        int numberOfEmployeesBeforeAddingAnotherOne = departmentDAO.getEmployees().size();
        departmentDAO.addEmployee(new HourlyEmployee("charles",
                LocalDate.of(2011, 3, 12),
                300, 20.0));
        assertEquals(numberOfEmployeesBeforeAddingAnotherOne + 1
                , departmentDAO.getEmployees().size());
    }

    @Test
    public void letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked_should_return_correct_number() {
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        assertEquals(2, numberOfEmployeesWhoWorked);
    }

    @Test
    public void computeDepartmentMonthlyTotalCompensation_should_return_correct_value() {
        double departmentMonthlyTotalCompensation = department.computeDepartmentMonthlyTotalCompensation();
        assertEquals(5000.0, departmentMonthlyTotalCompensation, 0.01);
    }
}