# dsa-java-review

The goal of this 1-day lab is to review and exercise basic yet  
essential Java concepts and features for the DS&A students. 

## Essential Java concepts covered 

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

## Advanced Java concepts

- Natural ordering
- Unit testing using Mockito
- DAO (Data Access Object) layer
- Generics
- TDD practices
- Lambda, Functional Interface, and Streams

## Solution code

The project contains the final solution code
along with this README.md file.

The same codebase is also available from 
[GitHub repo](https://github.com/sashinpivotal/dsa-java-review)
of this project.

## Lab step 1 - Java class and objects and Testing (45 minutes)

### Concepts that are exercised

- Java class and objects
  - Why Object-Oriented_Programming (OOP)?
  - What is "abstraction"?
  - What is "encapsulation"?
- Unit Testing
  - What is Unit testing for?

### Steps to take

- Create Maven project
  - Take a look at *pom.xml* file
  
- Create *com.hr.personnel* package
- Create *Employee* class under the *com.hr.personnel* 
  package with the following fields
  - String name
  - LocalDate hireDate
- Add the following methods to the *Employee* class
  - *String getEmployeeInfo()* method which returns *String* 
    type of "name = <employee-name>, hireDate = 2020-02-03"
  - *String work()* method that just returns *String*
    type of "<employee-name> worked"

- Create *com.hr.personnel.client* sub-package
- Write *HRClient* class under *com.hr.personnel.client* sub-package 
  - Create two *com.hr.personnel.Employee** objects 
    and calls *getEmployeeInfo* methods of those objects
  - Display the result in the console
  
- Add JUnit 4 dependency to the *pom.xm* as following. 
  Make sure to refresh Maven (click the Maven refresh icon
  in the top-right corner of the editor window of IntelliJ)
  so that IntelliJ download and install the *junit* dependency
  into local Maven repository.

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

### Concepts that are exercised

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

- Refactor *HRClient* class
  - Create two *SalariedEmployee*
    objects and one *HourlyEmployee* objects replacing
    *Employee* objects
  
- Create *Department* class under the *com.hr.personnel*
  package with the following fields:
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
- Is the following code going to work?
  If no, can compiler detect the problem?

```
Employee employee = new SalariedEmployee(..);
String name = employee.getName();
double salary = employee.getSalary()
```

## Lab Step 3 - Polymorphism (30 minutes)

### Concepts that are exercised

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

- Is it mandatory to use *@Override* annotation onto 
  an "overriding method"?
- If not, why is the usage of it still recommended?

## Lab Step 4 - Abstract class (20 minutes)

### Concepts that are exercised

- Abstract class
  - What is an abstract class?
  - When do you want to use it?

### Concrete steps

- Convert *Employee* class as an abstract class
  - Convert *computeMonthlyCompensation()* into an abstract method
  
- Refactor other code accordingly

### Optional exercise

- Convert *getEmployeeInfo()* of the *Employee* class
  into an abstract method

### Quiz

- All abstract methods of an abstract class need to be 
  implemented in a class that extends that abstract class:
  true or false?

## Lab Step 5 - Interface (45 minutes)

### Concepts that are exercised

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
- Write *CorporationTest* class testing *computeMonthlyTaxToPay()*

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
- Refactor code accordingly

### Quiz

- You have to use *abstract* keyword in each of the methods defined in 
  a Java interface, true or false?
- A class can implement multiple Java interfaces, true or false?
- An abstract class cannot implement Java interfaces, true or false?

## Lab Step 6 - Default method (20 minutes)

### Concepts that are exercised

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
    computing monthly tax to pay  
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

### Quizzes

- A Java interface can have only a single default method,
  true or false?
- You cannot override the default methods of an interface
  in the implementation classes, true or false?
- If a class implements interface A and interface B, both
  of which has the same default method, what will happen?

## Lab Step 7 - Exception handling (20 minutes)

### Concepts that are exercised

- Throwing an exception

### Concrete steps
  
- Add the following to the *HourlyEmployee* class

```
public static final double FEDERAL_MINIMUM_HOURLY_WAGE = 7.0;
```

- Refactor *HourlyEmployee* class so that, when *hourlyRate*
  is set to a value that is smaller than 
  *FEDERAL_MINIMUM_HOURLY_WAGE*, throw an *IllegalArgumentException*

- Add testing code to the *HourlyEmployeeTest* accordingly

### Optional exercise

- When throwing *IllegalArgumentException*, use the following
  message

```
"Illegal wage: " + hourlyRate + "." +
" Federal minimum wage is " + FEDERAL_MINIMUM_HOURLY_WAGE + "."
```

- Refactor *HourlyEmployeeTest* test to verify that the
  exception is thrown with an expected message

## Lab Step 8 - Custom exception (20 minutes)

### Concepts that are exercised

- Create and use a custom business level exception

### Concrete steps

- Create and use *IllegalHourlyWageException* class 
  instead of *IllegalArgumentException*

- If monthly salary for *SalariedEmployee* is set with 
  more than 1 million dollars, throw *TooMuchSalaryException*

- Refactor *HourlyEmployeeTest* and *SalariedEmployeeTest*
  accordingly

### Quizzes

- What is the difference between Checked exception vs
  Unchecked exception?
- What is the root class of the Unchecked exception?

## Lab Step 9 - Collection classes (20 minutes)

### Concepts that are exercised

- List vs Set
- LinkedList vs ArrayList?
- List/Set vs Map

### Concrete steps

- Refactor *Department* class to use a proper collection object 
  of *Employee* rather than an array
- Remove *currentIndex* field from the *Department* class

- Refactor *IRS* class to use a proper collection object of
  *TaxPayer* rather than an array
- Remove *currentIndex* field from the *IRS* class

- Refactor any code that need to be refactored accordingly

## Lab Step 10 - Singleton (20 minutes)

### Concepts that are exercised

- When do you want to use Singleton?

### Concrete steps

- Refactor *IRS* class as a singleton class as following
  - Make the constructor *private*
  - Create a static field that refers to the singleton object

```
    private static IRS instance;

    // Make the constructor private
    private IRS() {
    }

    // If singleton instance has not been created yet,
    // create one.  Otherwise, return the same instance.
    public static IRS getInstance() {
        if (instance == null) {
            instance = new IRS();
        }
        return instance;
    }
```

- Refactor *IRSTest* accordingly

### Resources

- [Singletons in Java](https://www.baeldung.com/java-singleton)

## Lab Step 11 - Constant class (20 minutes)

### Concepts that are exercised

- Constant classes

### Concrete steps

- Create *com.hr.personnel.EmployeeConstants* class
- Move all constants used in the same package to these classes
- Create *gov.irs.TaxConstants* class
- Move all constants used in the same package to these classes

- Refactor other codes accordingly
- Run all tests 

## Lab Step 12 - Simple JSON (30 minutes)

### Concepts that are exercised

- Using JSON utility class to read JSON data from a file

### Concrete steps

- Add *Simple JSON* dependency to the *pom.xml* or 
  Google search "maven simple json"
- Make sure to refresh "Maven" in IntelliJ so that
  IntelliJ downloads the *json-simple* dependency

```
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```

- Create *utilities* package
- Create *SimpleJSONUtility* class under the *utilities* package 
  with the following code

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

- Create *salariedEmployees.json* file under the project root
  with the following contents

```
[
  {
    "employee": {
      "name": "charles",
      "hireDate": "2020-01-03",
      "salary": "20000"
    }
  },
  {
    "employee": {
      "name": "kane",
      "hireDate": "2010-04-03",
      "salary": "10000"
    }
  }
]
```

- Modify *HRClient* to read JSON SalariedEmployee data from
  *salariedEmployees.json* file and then register 
  them to the *Department* object (instead of creating Employee
  objects directly inside the *HRClient*).  You can leverage 
  the following code fragment:

```
String jsonFilePath = "salariedEmployees.json";

JSONArray salariedEmployeesJSON
        = SimpleJSONUtility.readSalariedEmployeesJSON(jsonFilePath);
        
salariedEmployeesJSON.forEach(employeeJSON -> {
    Employee employee = SimpleJSONUtility.parseEmployeeObject((JSONObject) employeeJSON);
    department.addEmployee(employee);
});
```

## Lab Step 13 - Composition, Enum (30 minutes)

### Concepts that are exercised

- Composition
- Enum

### Concrete steps

- Create *CompanyHealth* enum under *com.hr.corp* package
  with the following values
  - HEALTHY
  - OK
  - SICK

- Create *Auditor* class under the same package with the
  *computeMonthlyProfit* method as following

```
public double computeMonthlyProfit(double monthlyIncome,
                                   double monthlyFixedCost,
                                   double monthlyTaxToPay ) {
    return monthlyIncome - (monthlyFixedCost + monthlyTaxToPay);
}
```

- Create and run *AuditorTest*

- In the *Corporation* class, create a new constructor, through
  which *Auditor* object gets injected
- Implement *performMonthlyAudit* method in the *Corporation* 
  class leveraging code below

```
public static final double MONTHLY_FIXED_COST = 10000.0;
public static final double MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY = 10000.0;
public static final double MINIMUM_PROFIT_TO_MAKE_TO_BE_OK = 0.0;

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

- Write *CorporationTest* class testing *performMonthlyAudit* method

## Lab Step 14 (Optional) - DAO (Data Access Object) layer

### Concepts that are exercised

- Right now, the *Department* class is responsible for the
  following two concerns - violation of Single Responsibility Principle
  - Business logic
  - Managing Employee objects
- We want to separate these two concerns by delegating
  the 2nd responsibility to *DepartmentDAO* class
  - We can change how Employee objects get managed later on,
    for example maintaining them in the database, without
    affecting the business logic

### Concrete steps to take

- Create *DepartmentDAO* class under the same package where
  *Department* class is located with the following code 

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

- Refactor *Department* class
  - In the *Department* class, create a new constructor, 
    through which the *DepartmentDAO* object gets injected
  - Use *DepartmentDAO* object for adding an employee
    or getting all employees

- Refactor and run *DepartmentTest* class accordingly

## Lab Step 15 (Optional) - Unit testing with Mockito

### Concepts that are exercised

- Unit testing with Mockito

### Concrete steps

- Add Mockito dependency to *pom.xml*
- Make sure to refresh "Maven" in IntelliJ so that
  IntelliJ downloads the *mockito-core* dependency

```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.5.1</version>
    <scope>test</scope>
</dependency>
```

- Refactor *CorporationTest* as following

```
package com.hr.corp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.hr.corp.Corporation.MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


