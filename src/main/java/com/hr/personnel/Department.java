package com.hr.personnel;

public class Department {

    private String name;
    private String location;

    private Employee[] employees = new Employee[100];

    public int getCurrentIndex() {
        return currentIndex;
    }

    private int currentIndex = 0;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addEmployee(Employee employee) {
        employees[currentIndex++] = employee;
    }

    public int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        int numberOfEmployeesWhoWorked = 0;
        for (int i = 0; i < currentIndex; i++) {
            String work = employees[i].work();
            if (work.contains("worked")) {
                numberOfEmployeesWhoWorked++;
            }
        }
        return numberOfEmployeesWhoWorked;
    }

}
