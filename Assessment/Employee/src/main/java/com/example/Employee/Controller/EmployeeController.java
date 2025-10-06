package com.example.Employee.Controller;


import com.example.Employee.Model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Alice", "Developer"),
                new Employee(2, "Bob", "Tester"),
                new Employee(3, "Charlie", "Manager")
        );
    }
}
