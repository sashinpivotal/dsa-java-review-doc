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

    public double computeDepartmentMonthlyTotalCompensation() {
        double departmentMonthlyTotalCompensation = 0.0;
        for (Employee employee: departmentDAO.getEmployees()) {
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
