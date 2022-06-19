package com.hr.personnel;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private String location;

    private List<Employee> employees = new ArrayList<>();

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        int numberOfEmployeesWhoWorked = 0;
        for (Employee employee: employees) {
            String work = employee.work();
            if (work.contains("worked")) {
                numberOfEmployeesWhoWorked++;
            }
        }
        return numberOfEmployeesWhoWorked;
    }

    public double computeDepartmentMonthlyTotalCompensation() {
        double departmentMonthlyTotalCompensation = 0.0;
        for (Employee employee: employees) {
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

    public List<Employee> getEmployees() {
        return employees;
    }

}
