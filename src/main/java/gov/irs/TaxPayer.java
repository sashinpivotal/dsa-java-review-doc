package gov.irs;

public interface TaxPayer {

    public static final double HOURLY_TAX_RATE = 0.25;
    public static final double SALARIED_TAX_RATE = 0.30;
    public static final double CORP_TAX_RATE = 0.10;

    public static final double DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION = 200.0;

    double computeMonthlyTaxToPay();

    default public double getStandardEmployeeMonthlyDeduction() {
        return DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION;
    }
}
