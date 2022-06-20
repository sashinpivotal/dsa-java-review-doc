package gov.irs;

import static gov.irs.TaxConstants.DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION;

public interface TaxPayer {

    double computeMonthlyTaxToPay();

    default public double getStandardEmployeeMonthlyDeduction() {
        return DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION;
    }
}
