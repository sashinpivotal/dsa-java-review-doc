package com.hr.personnel.client;

import com.hr.personnel.Department;
import com.hr.personnel.Employee;

import java.time.LocalDate;

public class HRClient {

    public static void main(String[] args) {
        Employee jon = new Employee("jon", LocalDate.of(2020, 1, 1));
        System.out.println(jon.getEmployeeInfo());
        Employee mary = new Employee("mary", LocalDate.of(2010, 3, 12));
        System.out.println(mary.getEmployeeInfo());

        Department department = new Department("marketing", "building3");
        department.addEmployee(jon);
        department.addEmployee(mary);
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        System.out.println("Number of employees who worked = " + numberOfEmployeesWhoWorked);
    }
}
