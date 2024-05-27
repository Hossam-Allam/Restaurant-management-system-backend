package com.restaurant.system.service;

import com.restaurant.system.model.Employee;
import com.restaurant.system.model.EmployeeLogin;
import com.restaurant.system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeLogin login(String username, String password){
        Employee employee = employeeRepository.findByUsername(username);
        if(employee != null && employee.getPassword().equals(password)){
            return new EmployeeLogin(true, employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getRole(), employee.getSalary());
        }
        else{
            return new EmployeeLogin(false);
        }
    }

    @Override
    public void updateSalary(int employeeId, double salary){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setSalary(salary);
            employeeRepository.save(employee);
        }
        else{
            throw new RuntimeException("Hossam :)");
        }
    }

    @Override
    public void updatePassword(int employeeId,String password){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setPassword(password);
            employeeRepository.save(employee);
        }
        else{
            throw new RuntimeException("invalid operation");
        }
    }
}
