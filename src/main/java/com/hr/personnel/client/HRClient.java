package com.hr.personnel.client;

import com.hr.personnel.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utilities.SimpleJSONUtility;

import java.time.LocalDate;

public class HRClient {

    public static void main(String[] args) {

        String JsonFilePath = "salariedEmployees.json";
        if (args.length >= 1) {
            JsonFilePath = args[0];
        }

        Employee jon = new SalariedEmployee("jon",
                LocalDate.of(2020, 1, 1),
                3000.0);
        Employee mary = new HourlyEmployee("mary",
                LocalDate.of(2010, 3, 12),
                200, 10.0);

        Department department = new Department("marketing", "building3", new DepartmentDAO());
        DepartmentDAO departmentDAO = department.getDepartmentDAO();
        departmentDAO.addEmployee(jon);
        departmentDAO.addEmployee(mary);

        JSONArray salariedEmployeesJSON
                = SimpleJSONUtility.readSalariedEmployeesJSON(JsonFilePath);
        salariedEmployeesJSON.forEach(employee -> {
            Employee employeeObject = SimpleJSONUtility.parseEmployeeObject((JSONObject) employee);
            departmentDAO.addEmployee(employeeObject);
        });

        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        System.out.println("Number of employees who worked = " + numberOfEmployeesWhoWorked);

        double departmentMonthlyTotalCompensation = department.computeDepartmentMonthlyTotalCompensation();
        System.out.println(department.getName() + "total monthly compensation = " + departmentMonthlyTotalCompensation);

        departmentDAO
                .getEmployees()
                .forEach(employee -> System.out.println(employee.getEmployeeInfo()));

    }
}
