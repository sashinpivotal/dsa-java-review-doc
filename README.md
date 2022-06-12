# dsa-java-review

The goal of this 1-day lab is to review basic yet essential Java features for DS&A students. St

## Essential topics to be covered

- Java classes and Java objects
- Inheritance vs Composition
- Polymorphism
- Java abstraction classes and Java interfaces
- Enum
- Collection classes
- Unit Testing and Integration Testing

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
  
- Create *Employee* class under *com.hr.personnel* package with the following fields
  - *String name*
  - *LocatDate hireDate* 
- Add the following methods
  - *String getEmployeeInfo()* method which returns *"Employee: name=" + getName() + ", hireDate=" + getHireDate()"*
  - *int getHoursWorked()* method that returns number of hours worked 

- Write *HTClient* class under *client" sub-package with creates multiple *Employee** objects and calls *getEmployeeInfo* methods of the objects
- Write Unit testing code that verifies that *getEmployeeInfo* method works as expected

## Lab Step 2 (Lab 8,2 of Java I)

### Concepts that will be covered during the step

- Inheritance
- Overriding methods

### Concepts that will be covered

- Create *SalariedEmployee* and *HourlyEmployee classes extending *Employee* class
- Create *Department* class with the following fields:
  - String name*
  - String location
  - Employee[] employees
  - int currentIndex
- Add the following methods
  - void addEmployee(Employee employee)
  - int computeTotalNumberOfHoursWorkedByDepartmentWorkers()

- Refactor *HRClient* class to use *Department* class
- Write unit test code for *Department* class

## Lab Step 3 (Lab 8.3 of Java 1)

### Conceepts that will be covered

- Inheritance
- Overriding methods

### Concrete steps to take

- Add *computeMonthlyCompensation()* to the *Employee* class

- *SalaryedEmployee* class implements *computeMonthlyCompensation()* method using *monthlySalary* private field
- *HourlyEmployee* class implements *computeMonthlyCompensation()* method using *hourlyRate* and *numberOfHoursWorkedPerMonth* fields
- Add *CommissionedEmployee* class with the following fields
  - private double commissionRate;
  - private ArrayList<Double> sales

- Write Unit testing code for both *SalariedEmployee* and *HourlyEmployee* classes

## Lab Step 4 (Lab 8.4)

### Concepts that will be exercised

- Abstract class

### Concreate steps

- Convert *Employee* class as abstract class making *computeMonthlyCompensation()* as an abstract method
- Refactor other code

## Lab Step 5 (lab 9.1)

### Concepts that will be exercised

- Interface

### Concreate steps

- Create *TaxPayer* interface with the following methods
  - double computeTax();   /// returns amount of tax to pay
- Add the following constants to the interface
  - public static final double HOURLY_TAX_RATE = 0.25;
  - public static final double SALARIED_TAX_RATE = 0.30;

- Make *Employee* abstract class to implement *TaxPayer* interface
- Refactor *SalariedEmployee* and "HourlyEmployee* classes accordingly

- Create *Corporation* class, which also implements *TaxPayer* interface

- Create *IRS* class with the following methods
  - double collectTaxes(); // collect Tax

## Lab Step 6 (lab 9.2)

### Concepts that will be exercised

- Default method in the interface

### Concreate steps

- Add the following method to the *TaxPayer* interface

```
    public static final double DEFAULT_STANDARD_DEDUCTION = 7500.0;

    default public double getStandardDeduction() {
        return DEFAULT_STANDARD_DEDUCTION;
    }
```

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




    