package com.restaurant.system.service;

import com.restaurant.system.model.Employee;
import com.restaurant.system.model.EmployeeLogin;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public EmployeeLogin login(String username, String password);

    public void updateSalary(int employeeId, double salary);

    public void updatePassword(int employeeId, String password);
}
