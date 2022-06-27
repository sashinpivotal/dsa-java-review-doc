package com.hr.personnel;

import java.time.LocalDate;

import static com.hr.personnel.EmployeeConstants.FEDERAL_MINIMUM_HOURLY_WAGE;
import static gov.irs.TaxConstants.HOURLY_TAX_RATE;

public class HourlyEmployee extends Employee {

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

    public void setHoursWorkedPerMonth(int hoursWorkedPerMonth) {
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < FEDERAL_MINIMUM_HOURLY_WAGE) {
            throw new IllegalHourlyWageException("Illegal wage: " + hourlyRate + "." +
                    " Federal minimum wage is " + FEDERAL_MINIMUM_HOURLY_WAGE + ".");
        }
        else {
            this.hourlyRate = hourlyRate;
        }
    }
}
