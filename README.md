# dsa-java-review

The goal of this 1-day lab is to review basic yet essential Java features for DS&A students. 

## Essential topics to be covered

- Java classes and Java objects
- Encapsulation
- Inheritance
- Polymorphism
- Java abstraction class
- Java interfaces
- Collection classes
- Unit Testing
- Singleton
- Constants class
- JSON utility (Simple JSON)
- Composition
- Enum

## Advanced topics

- Unit testing using Mockito
- Generics
- TDD practices
- Lambda, Functional Interface, and Streams

## Steps

Each step will be captured as a "tag" so that students can see the progress of the each step.  Students can see all the tags by typing "git tag".

## Lab step 1 

### Concepts that will be covered during the step

- Writing Java class and creating an object
- Unit testing

### Steps to take

- Create Maven project
  
- Create *com.hr.personnel.Employee* class under *com.hr.personnel* package with the following fields and appropriate accessor methods
  - String name
  - LocalDate hireDate
- Add the following methods
  - *String getEmployeeInfo()* method which returns *"name=" + getName() + ", hireDate=" + getHireDate()"*
  - *String work()* method that returns "<name> worked" message

- Write *HRClient* class under *com.hr.personnel.client* sub-package 
  - Create multiple *com.hr.personnel.Employee** objects and calls *getEmployeeInfo* methods of those objects
  
- Write Unit testing code of *com.hr.personnel.Employee* class
  - Verify that *getEmployeeInfo* and *work* methods work as expected

## Lab Step 2 (Lab 8,2 of Java I)

### Concepts that will be covered during the step

- Inheritance

### Steps to take

- Create *SalariedEmployee* and *HourlyEmployee classes extending *com.hr.personnel.Employee* class
  - Add the following fields and appropriate accessor methods to the *SalariedEmployee* class
    - double salary;
  - Add the following fields and appropriate accessor methods to the *HourlyEmployee* class
    - int hoursWorked;
    - double hourlyRate;
  
- Create *Department* class with the following fields:
  - String name
  - String location
  - com.hr.personnel.Employee[] employees array with 100 
  - int currentIndex
- Add the following methods to the *Department* class
  - void addEmployee(com.hr.personnel.Employee employee)
  - int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked()

- Refactor *HRClient* class to use *Department* class
- Write unit test code for *Department* class


## Lab Step 3 (Lab 8.3 of Java 1)

### Concepts that will be covered

- Overriding methods

### Concrete steps to take

- Add the following method to the *Employee* class
  - double computeMonthlyCompensation();

- Implement *computeMonthlyCompensation()* method in the *SalariedEmployee* class using *monthlySalary* private field
- Implement *computeMonthlyCompensation()* method in the *HourlyEmployee* class using *hourlyRate* and *hoursWorkedPerMonth* fields

- Add the following method to the *Department* class
  - double computeDepartmentMonthlyTotalCompensation()
  
- Write Unit testing code for both *SalariedEmployee* and *HourlyEmployee* classes
- Write testing method to the *DepartmentTest* class testing *computeDepartmentMonthlyTotalCompensation()* method

- (Optional) Add *CommissionedEmployee* class with the following fields
  - private double commissionRate
  - private ArrayList<Double> sales
- (Optional) Write testing code for *CommissionedEmployee* class

## Lab Step 4 (Lab 8.4)

### Concepts that will be exercised

- Abstract class

### Concrete steps

- Convert *Employee* class as abstract class
  - Make *computeMonthlyCompensation()* as an abstract method
- Refactor other code accordingly

## Lab Step 5 (lab 9.1)

### Concepts that will be exercised

- Interface

### Concrete steps

- Create *TaxPayer* interface under *gov.irs* package with the following methods
  - double computeMonthlyTaxToPay();   /// returns amount of tax to pay
- Add the following constants to the interface
  - public static final double HOURLY_TAX_RATE = 0.25;
  - public static final double SALARIED_TAX_RATE = 0.30;

- Make *com.hr.personnel.Employee* abstract class to implement *TaxPayer* interface
- Refactor *SalariedEmployee* and "HourlyEmployee* classes accordingly
- Refactor *SalariedEmployeeTest* and "HourlyEmployeeTest* classes accordingly

- Create *Corporation* class under "com.hr.corp" package with the following fields
  - String name;
- Add the following to the *TaxPayer* interface
  - public static final double CORP_TAX_RATE = 0.10;
- Make *Corporation* class implement *TaxPayer* interface
- Write *CorporationTest* class

- Create *IRS* class under *gov.irs* package with the following fields 
  - private TaxPayer[] taxPayers = new TaxPayer[100];
  - private int currentIndex = 0;  // for dealing with the array
- Add the following methods to the *IRS* class
  - double computeTotalMonthlyTaxToCollect(); // collect Tax
  - public void register(TaxPayer payer)
- Write *IRSTest* class testing *computeTotalMonthlyTaxToCollect()* method

## Lab Step 6 (lab 9.2)

### Concepts that will be exercised

- Default method in an Java interface

### Concrete steps

- Add the following method to the *TaxPayer* interface

```
public static final double DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION = 250.0;

default public double getStandardEmployeeMonthlyDeduction() {
    return DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION;
}
```

- Refactor *computeMonthlyTaxToPay* methods of *HourlyEmployee* and *SalariedEmployee* classes accordingly
  -When the monthly compensation is less than or equal to the DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION, *computeMonthlyTaxToPay* should return 0
- Refactor *HourlyEmployeeTest* and *SalariedEmployeeTest* accordingly
- Refactor *IRSTest*

## Lab Step 7 (lab 10.1)

### Concepts that will be exercised

- Throwing an exception

### Concrete steps
  
- Add the following to the *HourlyEmployee* class
  - public static final double FEDERAL_MINIMUM_HOURLY_WAGE = 7.0;

- Refactor *setHourlyRate* method to throw *IllegalArgumentException* in the *HourlyEmployee* class when the *hourlyRate* is smaller than *FEDERAL_MINIMUM_HOURLY_WAGE*

```
public void setHourlyRate(double hourlyRate) {
    if (hourlyRate < FEDERAL_MINIMUM_HOURLY_WAGE) {
        throw new IllegalArgumentException("Illegal wage: " + hourlyRate + "." +
                " Federal minimum wage is " + FEDERAL_MINIMUM_HOURLY_WAGE + ".");
    }
    else {
        this.hourlyRate = hourlyRate;
    }
}
```

- Refactor *HourlyEmployeeTest* test accordingly

## Lab Step 8 (lab 10.2)

### Concepts that will be exercised

- Create a custom exception

### Concrete steps

- Create and use *IllegalHourlyWageException* class instead of *IllegalArgumentException*

- (Optional) If monthly salary for *SalariedEmployee* is set with more than 1 million dollars, throw "MorallyWrongWageException"

## Lab Step 9 (Lab 11.1)

### Concepts that will be exercised

- Collection

### Concrete steps

- Refactor *Department* class to use a proper collection object of *Employee* rather than an array
- Remove *currentIndex* field from the *Department* class

- Refactor *IRS* class to use *ArrayList* rather than an array
- Remove *currentIndex* field from the *IRS* class

- Refactor any test code accordingly

## Lab Step 10

### Concepts that will be exercised

- Singleton class

### Concrete steps

- Refactor *IRS* class as a singleton class
- Refactor *IRSTest* accordingly

## Lab Step 11

### Concepts that will be exercises

- Constant class

### Concrete steps

- Create *com.hr.personnel.EmployeeConstants* and *gov.irs.YaxConstants* classes
- Move all constants to these classes

## Lab Step 12

### Concepts that will be exercises

- Using JSON utility class to read JSON data from a file

### Concrete steps

- Add *Simple JSON* dependency to the *pom.xml"

```
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```

- Create *SimpleJSONUtility* class under *utilities" package with the following code

```
package utilities;

import com.hr.personnel.Employee;
import com.hr.personnel.SalariedEmployee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class SimpleJSONUtility {

    private static JSONArray salariedEmployeesJSONArray;

    public static JSONArray readSalariedEmployeesJSON(String filePath)  {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(filePath)) {

            Object object = jsonParser.parse(fileReader);
            salariedEmployeesJSONArray = (JSONArray) object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return salariedEmployeesJSONArray;
    }

    public static Employee parseEmployeeObject(JSONObject salariedEmployeeJSONObject) {
        JSONObject employeeObject = (JSONObject) salariedEmployeeJSONObject.get("employee");
        String name = (String) employeeObject.get("name");
        String hireDate = (String) employeeObject.get("hireDate");
        String salary = (String) employeeObject.get("salary");
        return new SalariedEmployee(name, LocalDate.parse(hireDate), Double.valueOf(salary));
    }

}
```

- Modify *HRClient* to read JSON SalariedEmployee data and register them to the *Department* object.  You can leverage the following code fragment:

```
JSONArray salariedEmployeesJSON
        = SimpleJSONUtility.readSalariedEmployeesJSON(JsonFilePath);
salariedEmployeesJSON.forEach(employee -> {
    Employee employeeObject = SimpleJSONUtility.parseEmployeeObject((JSONObject) employee);
    department.addEmployee(employeeObject);
});
```

## Lab Step 13

### Concepts that will be exercises

- Composition
- Enum

### Concrete steps

- Create *CompanyHealth* enum with tge following values
  - HEALTHY
  - OK
  - SICK

- Create *Auditor* class with *performMonthlyAudit* method as following

```
public CompanyHealth performMonthlyAudit(double monthlyProfit, 
                                        double monthlyFixedCost, 
                                        double monthlyTaxToPay ) {

    CompanyHealth auditorOpinion = CompanyHealth.OK;

    if (monthlyProfit > monthlyFixedCost + monthlyTaxToPay) {
        auditorOpinion = CompanyHealth.HEALTHY;
    } else if (monthlyProfit < monthlyFixedCost + monthlyTaxToPay) {
        auditorOpinion = CompanyHealth.SICK;
    }

    return auditorOpinion;
}
```

- Create and run *AuditorTest*
- Add the following code to *Corpoation* class

```
public static final double MONTHLY_FIXED_COST = 10000.0;

public CompanyHealth performMonthlyAudit() {
    return auditor.performMonthlyAudit(monthlyProfit, MONTHLY_FIXED_COST, computeMonthlyTaxToPay());
}
```

- Create *CorpClient* class under *com.hr.corp.client" package
  - Write code to get company health 
    
## Lab Step 14 (Optional)

### Concepts that will be exercises

- Unit testing with Mockito

### Concrete steps

- Add Mockito depdendency to *pom.xml*

```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.5.1</version>
    <scope>test</scope>
</dependency>
```

- Refactor *Auditor* Code as following

```
public class Auditor {

    public double performMonthlyAudit(double monthlyIncome,
                                             double monthlyFixedCost,
                                             double monthlyTaxToPay ) {
        return monthlyIncome - (monthlyFixedCost + monthlyTaxToPay);
    }
}
```

- Refactor *AuditorTest* accordingly

- Refactor *performMonthlyAudit()* method of *Corporation* as following

```
public CompanyHealth performMonthlyAudit() {

    double monthlyProfit
            = auditor.performMonthlyAudit(monthlyIncome, MONTHLY_FIXED_COST, computeMonthlyTaxToPay());

    CompanyHealth companyHealth = CompanyHealth.SICK;

    if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY) {
        companyHealth = CompanyHealth.HEALTHY;
    } else if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_OK) {
        companyHealth = CompanyHealth.OK;
    }

    return companyHealth;

}
```

- Refactor *CorporationTest* as following

```
@RunWith(MockitoJUnitRunner.class)
public class CorporationTest {

    private Corporation myCorporation;

    @Mock
    private Auditor auditor;

    @Before
    public void setUp() throws Exception {
        myCorporation = new Corporation("myCompany", 1000000.0, auditor);
    }

    @Test
    public void computeMonthlyTaxToPay_computes_monthly_tax_correctly() {

        double monthlyTaxToPay = myCorporation.computeMonthlyTaxToPay();
        assertEquals(100000.0, monthlyTaxToPay, 0.01);
    }

    @Test
    public void performMonthlyAudit_should_return_HEALTHY_when_profit_is_greater_than_threshold() {

        // arrange
        when(auditor.performMonthlyAudit(anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY);

        // act and assert
        CompanyHealth companyHealth = myCorporation.performMonthlyAudit();
        Assert.assertEquals(CompanyHealth.HEALTHY, companyHealth);

        // verify
        verify(auditor).performMonthlyAudit(anyDouble(), anyDouble(), anyDouble());
    }
}
```
- Run all tests and verify success