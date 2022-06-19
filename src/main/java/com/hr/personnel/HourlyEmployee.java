package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    public static final double FEDERAL_MINIMUM_HOURLY_WAGE = 7.0;

    private int hoursWorkedPerMonth;

    private double hourlyRate;

    public HourlyEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    public HourlyEmployee(String name, LocalDate hireDate, int hoursWorkedPerMonth, double hourlyRate) {
        super(name, hireDate);
        setHoursWorkedPerMonth(hoursWorkedPerMonth);
        setHourlyRate(hourlyRate);
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

    public int getHoursWorkedPerMonth() {
        return hoursWorkedPerMonth;
    }

    public void setHoursWorkedPerMonth(int hoursWorkedPerMonth) {
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < FEDERAL_MINIMUM_HOURLY_WAGE) {
            throw new IllegalArgumentException("Illegal wage: " + hourlyRate + "." +
                    " Federal minimum wage is " + FEDERAL_MINIMUM_HOURLY_WAGE + ".");
        }
        else {
            this.hourlyRate = hourlyRate;
        }
    }
}
