# dsa-java-review

The goal of this 1-day lab is to review basic yet essential Java features for DS&A students. St

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

## Advanced topics

- Generics
- TDD practices
- Lambda, Functional Interface, and Streams

## Steps

Each step will be captured as a "tag" so that students can see the progress of the each step.  Students can see all the tags by typing "git tag".

## Lab step 1 

### Concepts that will be covered during the step

- Writing Java class and creating an object
- Unit testing

### Concreate steps to take

- Create Maven project
  
- Create *com.hr.personnel.Employee* class under *com.hr.personnel* package with the following fields and appropriate accessor methods
  - *String name*
  - *LocatDate hireDate* 
- Add the following methods
  - *String getEmployeeInfo()* method which returns *"name=" + getName() + ", hireDate=" + getHireDate()"*
  - *String work()* method that returns "<name> worked" message

- Write *HRClient* class under *client" sub-package with creates multiple *com.hr.personnel.Employee** objects and calls *getEmployeeInfo* methods of the objects
- Write Unit testing code that verifies that *getEmployeeInfo* and *work* methods work as expected

## Lab Step 2 (Lab 8,2 of Java I)

### Concepts that will be covered during the step

- Inheritance
- Overriding methods

### Concepts that will be covered

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

- (Optional) add the following method to *Department* class
  - void removeEmployee(String employeeName)

## Lab Step 3 (Lab 8.3 of Java 1)

### Conceepts that will be covered

- Inheritance
- Overriding methods

### Concrete steps to take

- Add the following method to the *Employee* class
  - double computeMonthlyCompensation();

- *SalariedEmployee* class implements *computeMonthlyCompensation()* method using *monthlySalary* private field
- *HourlyEmployee* class implements *computeMonthlyCompensation()* method using *hourlyRate* and *hoursWorkedPerMonth* fields

- Add the following method to the *Department* class
  - double computeDepartmentMonthlyTotalCompensation()
  
- (Optional) Add *CommissionedEmployee* class with the following fields
  - private double commissionRate;
  - private ArrayList<Double> sales

- Write Unit testing code for both *SalariedEmployee* and *HourlyEmployee* classes
- Write testing method to the *DepartmentTest* class testing *computeDepartmentMonthlyTotalCompensation()* method

## Lab Step 4 (Lab 8.4)

### Concepts that will be exercised

- Abstract class

### Concreate steps

- Convert *.Employee* class as abstract class making *computeMonthlyCompensation()* as an abstract method
- Refactor other code

## Lab Step 5 (lab 9.1)

### Concepts that will be exercised

- Interface

### Concreate steps

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

### Concreate steps

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

### Concreate steps

- Throw *IllegalArgumentException* in the *HourlyEmployee* class

```
    public void setRate(double rate) {
        if (rate < FEDERAL_MINIMUM_WAGE) {
            throw new IllegalArgumentException("Illegal wage: " + rate + "." +
                    " Federal minimum wage is " + FEDERAL_MINIMUM_WAGE + ".");
        }
        else {
            this.rate = rate;
        }
    }
```

## Lab Step 8 (lab 10.2)

### Concepts that will be exercised

- Create custom exception

### Concreate steps

- Use *IllegalWageException* class instead of *IllegalArgumentException*

## Lab Setp 9 (Lab 11.1)

### Concepts that will be exercised

- Collection

### Concrete steps

- Refactor *Department* class to use *ArrayList* instead of an array
- Refactor *IRS* class to use *ArrayList* instead of an array

## Lab Step 10

### Concepts that will be exercised

- Singleton class

### Concrete steps

- Refactor *IRS* class as a singleton class

## Lab Step 11

### Concepts that will be exercises

- Enum

### Concrete steps




    