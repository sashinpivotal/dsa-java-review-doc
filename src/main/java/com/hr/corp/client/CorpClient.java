package com.hr.corp.client;

import com.hr.corp.Auditor;
import com.hr.corp.CompanyHealth;
import com.hr.corp.Corporation;

public class CorpClient {

    public static void main(String[] args) {
        Corporation myCompany = new Corporation("MyCompany", 30000.0, new Auditor());
        CompanyHealth companyHealth = myCompany.performMonthlyAudit();
        System.out.println("MyCompany's financial health is " + companyHealth);
    }
}
