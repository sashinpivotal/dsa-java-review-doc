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

- Natural ordering
- Unit testing using Mockito
- DAO (Data Access Object) layer
- Generics
- TDD practices
- Lambda, Functional Interface, and Streams

## Steps

Each step will be captured as a "tag" so that students can see 
the progress of each step.  Students can see all the tags 
by typing "git tag".

## Lab step 1 - Create Java class and test (45 minutes)

### Concepts that will be exercised during the step

- Writing Java class and creating an object
  - Why Object-Oriented_Programming (OOP)?
  - What is "abstraction"?
  - What is "encapsulation"?
- Unit testing
  - What is Unit testing for?

### Steps to take

- Create Maven project
  - Take a look at *pom.xml* file
  
- Create *com.hr.personnel* package
- Create *Employee* class under the *com.hr.personnel* package with the following fields
  - String name
  - LocalDate hireDate
- Add the following methods to the *Employee* class
  - *String getEmployeeInfo()* method which returns *String* type of something like "name = sang, hireDate = 2020-02-03"
  - *String work()* method that just returns "<name> worked" message

- Write *HRClient* class under *com.hr.personnel.client* sub-package 
  - Create two *com.hr.personnel.Employee** objects and calls *getEmployeeInfo* methods of those objects
  
- Add JUnit 4 dependency to the *pom.xm* as following. 
  Make sure to refresh Maven (click the Maven refresh icon)
  so that IntelliJ download the *junit* dependency.

```xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

- Write Unit testing code of *com.hr.personnel.Employee* class
  - Verify that *getEmployeeInfo* and *work* methods work as expected

### Optional exercise 

- Add another method below to the *Employee* class

```
    // If current year is 2022 and the year of hireDate is
    // 2020, it returns 2
    public int computeNumberOfYearsWorkedSinceHired() {
        // add code here - do not use deprecated method
    }
```

- Write test code of the above method

### Quiz

- What are the differences among the following access modifiers?
  - private
  - default (package-private)
  - protected
  - public
- What is *@Before* annotation (in JUnit 4) for in your testing code?

## Lab Step 2 - Inheritance (30 minutes)

### Concepts that will be exercised during the step

- Inheritance
  - When do you want to use inheritance?
  - What could be example sub-classes of *Employee* class?

### Steps to take

- Create *SalariedEmployee* and *HourlyEmployee* classes 
  extending *com.hr.personnel.Employee* class

  - Add the following fields and appropriate accessor 
    methods to the *SalariedEmployee* class
    - double monthlySalary;
  - Add the following fields and appropriate accessor 
    methods to the *HourlyEmployee* class
    - int hoursWorkedPerMonth;
    - double hourlyRate;

- Refactor *HRClient* class to create two *SalariedEmployee*
  objects and one *HourlyEmployee* objects replacing
  *Employee* objects
  
- Create *com.hr.personnel.Department* class with the following fields:
  - String name
  - String location
  - com.hr.personnel.Employee[] employees array with size of 100 
  - int currentIndex
  
- Add the following methods to the *Department* class
  - void addEmployee(com.hr.personnel.Employee employee)
  - int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked()

- Refactor *HRClient* class to use *Department* class

- Write test code for the *Department* class
  - Test *addEmployee* method
  - Test *letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked* method

### Quiz

- Can a sub-class access private fields or methods of a parent class?
- What fields does an *HourlyEmployee* object have?
- Is the following code going to work?
  If no, can compiler detect the problem?

```
Employee employee = new SalariedEmployee(..);
String name = employee.getName();
double salary = employee.getSalary()
```

## Lab Step 3 - Polymorphism

### Concepts that will be exercised

- Overriding methods 
  - What is an "overriding method"? When do you want to use it?

- Polymorphism
  - What is it?
  - What is an example of polymorphic behavior in Java?

### Concrete steps to take

- Add the following method to the *Employee* class with 
  proper access modifier 
  - double computeMonthlyCompensation() { return 0.0; };

- Implement *computeMonthlyCompensation()* method 
  in the *SalariedEmployee* class using *monthlySalary* field

- Implement *computeMonthlyCompensation()* method 
  in the *HourlyEmployee* class using *hourlyRate* 
  and *hoursWorkedPerMonth* fields

- Add and implement the following method to the *Department* class.
  It should return total monthly compensation of all employees in
  that department.
  - double computeDepartmentMonthlyTotalCompensation()
  
- Write testing code for both *SalariedEmployee* 
  and *HourlyEmployee* classes testing
  *computeMonthlyCompensation()* method

- Add code in the *HRClient* class to display the result of
  calling *computeDepartmentMonthlyTotalCompensation()* method

- Write testing method in the *DepartmentTest* class 
  testing *computeDepartmentMonthlyTotalCompensation()* method

### Optional exercise

- Add *CommissionedEmployee* class with the following fields
  - private double commissionRate
  - private ArrayList<Double> monthlySales
  
- Implement *computeMonthlyCompensation()* method for the
  *CommissionedEmployee*
  - The monthly compensation for the *CommissionedEmployee*
    is total of commissionRate * <each-sale-amount>
  
- Write testing code for *CommissionedEmployee* class
  testing *computeMonthlyCompensation()* method

### Quiz

- Is it mandatory to use *@Override* annotation on 
  an "overriding method"?
- If not, why is the usage of it still recommended?

## Lab Step 4 - Abstract class

### Concepts that will be exercised

- Abstract class
  - What is an abstract class?
  - When do you want to use it?

### Concrete steps

- Convert *Employee* class as an abstract class
  - Convert *computeMonthlyCompensation()* into an abstract method
  
- Refactor other code accordingly

### Optional exercise

- Convert *getEmployeeInfo()* into an abstract method

### Quiz

- All abstract methods of an abstract class need to be 
  implemented in a class that extends the abstract class:
  true or false?

## Lab Step 5 - Interface

### Concepts that will be exercised

- Interface
  - When do you want to use Java interface?

### Concrete steps

- Create *gov.irs* package
- Create *TaxPayer* interface under *gov.irs* package with 
  the following methods
  - double computeMonthlyTaxToPay(); // returns amount of tax to pay
  
- Add the following constants to the interface - these are tax rates
  - public static final double HOURLY_TAX_RATE = 0.25;
  - public static final double SALARIED_TAX_RATE = 0.30;

- Make *com.hr.personnel.Employee* abstract class to 
  implement *TaxPayer* interface
- Refactor *SalariedEmployee* and *HourlyEmployee* classes accordingly
  - Add "monthly-tax computing" logic to the *computeMonthlyTaxToPay()*   
    method using tax rates defined above 
- Add testing code in the *SalariedEmployeeTest* and *HourlyEmployeeTest* 
  classes accordingly

- Create *com.hr.corp* package
- Create *Corporation* class under *com.hr.corp* package with 
  the following fields
  - String name;
  - double monthlyIncome;
- Add the following to the *TaxPayer* interface
  - public static final double CORP_TAX_RATE = 0.10;
- Make *Corporation* class implement *TaxPayer* interface
  - Corp tax can be computed as *monthlyIncome * CORP_TAX_RATE*
- Write *CorporationTest* class

- Create *IRS* class under *gov.irs* package with the following fields 
  - private TaxPayer[] taxPayers = new TaxPayer[100];
  - private int currentIndex = 0;  // for dealing with the array
- Add and implement the following methods to the *IRS* class
  - double computeTotalMonthlyTaxToCollect()
  - void register(TaxPayer taxPayer)
- Write *IRSTest* class testing *computeTotalMonthlyTaxToCollect()* method

### Optional exercise

- We would like to add natural ordering to the *Employee* objects
  as following:
  - Compare them based on *hireDate* first
  - If multiple employees have the same *hireDate*, 
    use their *name* next
- Add *Comparable* interface to the *Employee* class
- Refactor other code accordingly

### Quiz

- You have to use *abstract* keyword in each of the methods defined in 
  a Java interface, true or false?
- A class can implement multiple Java interfaces, true or false?

## Lab Step 6 - Default method

### Concepts that will be exercised

- Default method in a Java interface

### Concrete steps

- Add the following method to the *TaxPayer* interface

```
public static final double DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION = 250.0;

default double computeStandardEmployeeMonthlyDeduction() {
    return DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION;
}
```

- Refactor *computeMonthlyTaxToPay* methods of *HourlyEmployee* 
  and *SalariedEmployee* classes as following
  - Apply DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION when
    computing monthly tax pay  
  - When the monthly tax to pay is less than or equal to 
    the DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION, 
    return 0.0
- Refactor *HourlyEmployeeTest* and *SalariedEmployeeTest* testing
  code accordingly
  - Make sure you test the case in which the monthly tax to pay 
    is less than or equal to the DEFAULT_STANDARD_EMPLOYEE_MONTHLY_DEDUCTION
- Refactor *IRSTest* testing code accordingly

### Optional exercise

- Add another default method to the *TaxPayer* interface

```text
    default String getCurrentDayAndTime() {
        // return String in the format of "yyyy/MM/dd HH:mm:ss"
    }
```

### Resources

- [Static and Default Methods in Interfaces in Java](https://www.baeldung.com/java-static-default-methods)

### Quiz

- You cannot override the default methods of an interface
  in the implementation classes, true or false?
- If a class implements interface A and interface B, both
  of which has the same default method, what will happen?

## Lab Step 7 - Exception handling

### Concepts that will be exercised

- Throwing an exception

### Concrete steps
  
- Add the following to the *HourlyEmployee* class

```
public static final double FEDERAL_MINIMUM_HOURLY_WAGE = 7.0;
```

- Refactor *HourlyEmployee* class so that, when *hourlyRate*
  is set to a value that is smaller than 
  *FEDERAL_MINIMUM_HOURLY_WAGE*, *IllegalArgumentException*
  is thrown

- Refactor *HourlyEmployeeTest* test accordingly

### Optional exercise

- When throwing *IllegalArgumentException*, use the following
  message

```
"Illegal wage: " + hourlyRate + "." +
" Federal minimum wage is " + FEDERAL_MINIMUM_HOURLY_WAGE + "."
```

- Refactor *HourlyEmployeeTest* test to verify that the
  exception is thrown with expected message

## Lab Step 8 - Custom exception

### Concepts that will be exercised

- Create a custom exception

### Concrete steps

- Create and use *IllegalHourlyWageException* class instead of *IllegalArgumentException*

- (Optional) If monthly salary for *SalariedEmployee* is set with more than 1 million dollars, throw "MorallyWrongWageException"

## Lab Step 9 - Collection classes

### Concepts that will be exercised

- Collection

### Concrete steps

- Refactor *Department* class to use a proper collection object of *Employee* rather than an array
- Remove *currentIndex* field from the *Department* class

- Refactor *IRS* class to use *ArrayList* rather than an array
- Remove *currentIndex* field from the *IRS* class

- Refactor any test code accordingly

## Lab Step 10 - Singleton class

### Concepts that will be exercised

- Singleton class

### Concrete steps

- Refactor *IRS* class as a singleton class
- Refactor *IRSTest* accordingly

## Lab Step 11 - Constant class

### Concepts that will be exercises

- Constant class

### Concrete steps

- Create *com.hr.personnel.EmployeeConstants* and *gov.irs.YaxConstants* classes
- Move all constants to these classes

## Lab Step 12 - Simple JSON

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

- Modify *HRClient* to read JSON SalariedEmployee data and register 
  them to the *Department* object.  You can leverage the following code fragment:

```
JSONArray salariedEmployeesJSON
        = SimpleJSONUtility.readSalariedEmployeesJSON(JsonFilePath);
salariedEmployeesJSON.forEach(employee -> {
    Employee employeeObject = SimpleJSONUtility.parseEmployeeObject((JSONObject) employee);
    department.addEmployee(employeeObject);
});
```

## Lab Step 13 - Composition, Enum

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
    
## Lab Step 14 (Optional) - Unit testing with Mockito

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

    public double computeMonthlyProfit(double monthlyIncome,
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
            = auditor.computeMonthlyProfit(monthlyIncome, MONTHLY_FIXED_COST, computeMonthlyTaxToPay());

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
        when(auditor.computeMonthlyProfit(anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY);

        // act and assert
        CompanyHealth companyHealth = myCorporation.performMonthlyAudit();
        Assert.assertEquals(CompanyHealth.HEALTHY, companyHealth);

        // verify
        verify(auditor).computeMonthlyProfit(anyDouble(), anyDouble(), anyDouble());
    }
}
```
- Run all tests and verify success

## Lab Step 15 (Optional) - DAO (Data Access Object) layer

### Concepts that will be exercises

- DAO (Data Access Object) layer

### Concrete steps to take

- Create *DepartmentDAO* class as following - it is now responsbile for managing Employee data

```
public class DepartmentDAO {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
```

- Refactor other code accordingly

