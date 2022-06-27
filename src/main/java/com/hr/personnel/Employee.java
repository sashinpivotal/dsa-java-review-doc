package com.hr.personnel;

import gov.irs.TaxPayer;

import java.time.LocalDate;

public abstract class Employee implements TaxPayer {

    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public abstract double computeMonthlyCompensation();

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
        return name + " " + EmployeeConstants.EMPLOYEE_HAS_WORKED_THIS_MONTH;
    }

}
