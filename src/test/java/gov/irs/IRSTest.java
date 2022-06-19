package gov.irs;

import com.hr.corp.Corporation;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IRSTest {

    private static IRS irs;

    @BeforeClass
    public static void beforeClass() throws Exception {
        irs = IRS.getInstance();
    }

    @Before
    public void setUp() throws Exception {
        // We need to clear the taxPayers before each test
        List<TaxPayer> taxPayers = IRS.getInstance().getTaxPayers();
        taxPayers.clear();

        Corporation yourCompany = new Corporation("yourCompany", 200000.0);
        irs.register(yourCompany);
        SalariedEmployee jon = new SalariedEmployee("jon",
                LocalDate.of(2020, 3, 4),
                20000.0);
        irs.register(jon);
        HourlyEmployee mary = new HourlyEmployee("mary",
                LocalDate.of(2020, 3, 4),
                100, 10.0);
        irs.register(mary);
    }

    @Test
    public void computeTotalMonthlyTaxToCollect_computes_correctly_given_both_employees_and_corp() {
        double totalMonthlyTaxToCollect = irs.computeTotalMonthlyTaxToCollect();
        assertEquals(25850.0, totalMonthlyTaxToCollect, 0.01);
    }

    @Test
    public void computeTotalMonthlyTaxToCollect_computes_correctly_given_employee_who_makes_less_than_standard_deduction() {
        SalariedEmployee simon = new SalariedEmployee("simon",
                LocalDate.of(2020, 3, 4),
                100.0);
        irs.register(simon);
        double totalMonthlyTaxToCollect = irs.computeTotalMonthlyTaxToCollect();
        assertEquals(25850.0, totalMonthlyTaxToCollect, 0.01);
    }
}