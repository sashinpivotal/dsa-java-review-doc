package gov.irs;

import java.util.ArrayList;
import java.util.List;

public class IRS {

    private static IRS instance;

    private IRS() {
    }

    public static IRS getInstance() {
        if (instance == null) {
            instance = new IRS();
        }
        return instance;
    }

    private List<TaxPayer> taxPayers = new ArrayList<>();

    public double computeTotalMonthlyTaxToCollect() {
        double totalMonthlyTaxToCollect = 0.0;
        for (TaxPayer taxPayer : taxPayers) {
            totalMonthlyTaxToCollect += taxPayer.computeMonthlyTaxToPay();
        }
        return totalMonthlyTaxToCollect;
    }

    public void register(TaxPayer taxPayer) {
        taxPayers.add(taxPayer);
    }

    public List<TaxPayer> getTaxPayers() {
        return taxPayers;
    }

    public void setTaxPayers(List<TaxPayer> taxPayers) {
        this.taxPayers = taxPayers;
    }

}
