package com.hr.personnel.client;

import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

import java.time.LocalDate;

public class HRClient {

    public static void main(String[] args) {

        Employee jon = new SalariedEmployee("jon",
                LocalDate.of(2020, 1, 1),
                3000.0);
        Employee mary = new HourlyEmployee("mary",
                LocalDate.of(2010, 3, 12),
                200, 10.0);

        Department department = new Department("marketing", "building3");
        department.addEmployee(jon);
        department.addEmployee(mary);
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        System.out.println("Number of employees who worked = " + numberOfEmployeesWhoWorked);

        double departmentMonthlyTotalCompensation = department.computeDepartmentMonthlyTotalCompensation();
        System.out.println(department.getName() + "total monthly compensation = " + departmentMonthlyTotalCompensation);

    }
}
