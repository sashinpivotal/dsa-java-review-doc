package com.hr.personnel;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
