package com.hr.personnel;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private String location;

    private DepartmentDAO departmentDAO;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Department(String name, String location, DepartmentDAO departmentDAO) {
        this(name, location);
        this.departmentDAO = departmentDAO;
    }

    public int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        int numberOfEmployeesWhoWorked = 0;
        for (Employee employee: departmentDAO.getEmployees()) {
            String work = employee.work();
            if (work.contains(EmployeeConstants.EMPLOYEE_HAS_WORKED_THIS_MONTH)) {
                numberOfEmployeesWhoWorked++;
            }
        }
        return numberOfEmployeesWhoWorked;
    }

    // You can observe polymorphic behavior of Java here.
    // - When "computeMonthlyCompensation()" method is invoked
    //   on an "Employee" object, what gets invoked is the one
    //   from the sub-classes.
    // - In other words, "computeMonthlyCompensation()" method
    //   of "SalariedEmployee" or "HourlyEmployee" sub-class
    //   (not the one from the "Employee" class) gets invoked
    //   depending on what object the "employee" variable
    //   refers to during runtime
    public double computeDepartmentMonthlyTotalCompensation() {
        double departmentMonthlyTotalCompensation = 0.0;
        for (Employee employee: departmentDAO.getEmployees()) {
            System.out.println("employee class: " + employee.getClass());
            double monthlyCompensation = employee.computeMonthlyCompensation();
            departmentMonthlyTotalCompensation += monthlyCompensation;
        }
        return departmentMonthlyTotalCompensation;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }
}
