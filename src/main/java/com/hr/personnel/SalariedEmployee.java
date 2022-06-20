package com.hr.personnel;

import java.time.LocalDate;

import static gov.irs.TaxConstants.SALARIED_TAX_RATE;

public class SalariedEmployee extends Employee {

    private double monthlySalary;

    public SalariedEmployee(String name, LocalDate hireDate, double monthlySalary) {
        super(name, hireDate);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double computeMonthlyCompensation() {
        return monthlySalary;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        double monthlyTaxToPayBeforeDeduction
                =  computeMonthlyCompensation() * SALARIED_TAX_RATE;
        double standardEmployeeMonthlyDeduction = getStandardEmployeeMonthlyDeduction();
        return monthlyTaxToPayBeforeDeduction <= standardEmployeeMonthlyDeduction ?
                0.0: monthlyTaxToPayBeforeDeduction - standardEmployeeMonthlyDeduction;
    }
}
