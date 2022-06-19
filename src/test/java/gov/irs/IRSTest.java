package gov.irs;

import com.hr.corp.Corporation;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class IRSTest {

    private IRS irs;

    @Before
    public void setUp() throws Exception {
        irs = new IRS();
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
        Assert.assertEquals(26300.0, totalMonthlyTaxToCollect, 0.01);
    }
}