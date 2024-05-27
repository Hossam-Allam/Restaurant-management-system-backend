package com.restaurant.system.controller;

import com.restaurant.system.model.Employee;
import com.restaurant.system.model.EmployeeLogin;
import com.restaurant.system.repository.EmployeeRepository;
import com.restaurant.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "Successfully jobbed";
    }

    @PostMapping("/login")
    public EmployeeLogin employeeLogin(@RequestBody Map<String,String> loginRequest){
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        return employeeService.login(username, password);
    }

    @PutMapping("/salary")
    public String newSalary(@RequestParam int employeeId, double salary){
        employeeService.updateSalary(employeeId, salary);
        return "salary changed to " + salary;
    }

    @PutMapping("/password")
    public String newPassword(@RequestParam int employeeId, String password){
        employeeService.updatePassword(employeeId, password);
        return "password changed to.....nvm";
    }

}
