package com.hr.personnel;

import java.time.LocalDate;

public class Employee {

    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public double computeMonthlyCompensation() {
        return 0;
    }

    public String getEmployeeInfo() {
        return ("name = " + getName() + ", hireDate = " + getHireDate() );
    }

    public String getHireDate() {
        return hireDate.toString();
    }

    public String getName() {
        return name;
    }

    public String work() {
        return name + " worked";
    }

}
