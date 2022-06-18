package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    public HourlyEmployee(String name, LocalDate hireDate, int hoursWorked, double hourlyRate) {
        super(name, hireDate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
}
