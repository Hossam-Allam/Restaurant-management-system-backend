package com.restaurant.system.model;

public class EmployeeLogin {

    private boolean authenticated;
    private Integer employeeId;
    private String name;
    private String surname;
    private String role;
    private double salary;

    public EmployeeLogin(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public EmployeeLogin(boolean authenticated, Integer employeeId, String name, String surname, String role, double salary) {
        this.authenticated = authenticated;
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.salary = salary;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
