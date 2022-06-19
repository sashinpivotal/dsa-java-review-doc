package gov.irs;

import java.util.ArrayList;
import java.util.List;

public class IRS {

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

}
