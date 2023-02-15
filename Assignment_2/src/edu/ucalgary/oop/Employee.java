package edu.ucalgary.oop;

/*
File Edited by: Koen Schoffner
version 1.1
 */
class Employee {
    private String name;
    private final String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployees = new Employee[10];

    public Employee(String name, String iDNumber) {
        this.name = name;
        this.IDNUMBER = iDNumber;
    }

    public Employee(String name, String iDNumber, String managerID) {
        this.name = name;
        this.IDNUMBER = iDNumber;
        this.managerID = managerID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber() {
        return this.IDNUMBER;
    }

    public String getManagerID() {
        if (managerID == null) {
            return null;
        } else {
            return this.managerID;
        }
    }

    public void setManagerID(String newManger) {
        this.managerID = newManger;
    }

    public void addEmployee(Employee newEmployee) {
        if (supervisedEmployees[9] != null) {
            System.out.println("Error: Too many Employees. Max: 10");
        }
        for (int i = 0; i < 10; i++) {
            if (supervisedEmployees[i] == null) {
                supervisedEmployees[i] = newEmployee;
                break;
            }
        }

    }

    public Employee[] getEmployees() {
        return this.supervisedEmployees;
    }


}
