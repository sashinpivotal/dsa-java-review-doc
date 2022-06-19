package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    private int hoursWorkedPerMonth;
    private double hourlyRate;

    public HourlyEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    public HourlyEmployee(String name, LocalDate hireDate, int hoursWorkedPerMonth, double hourlyRate) {
        super(name, hireDate);
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computeMonthlyCompensation() {
        return hoursWorkedPerMonth * hourlyRate;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        double monthlyTaxToPayBeforeDeduction = computeMonthlyCompensation() * HOURLY_TAX_RATE;
        double standardEmployeeMonthlyDeduction = getStandardEmployeeMonthlyDeduction();
        return monthlyTaxToPayBeforeDeduction <= standardEmployeeMonthlyDeduction ?
                0.0 : monthlyTaxToPayBeforeDeduction - standardEmployeeMonthlyDeduction;
    }
}
