package com.javatechie.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootAzuresqlApplication {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
//    	@RequestParam("dept") String dept, @RequestParam("name") String name, @RequestParam("salary") Long salary
//    	Employee employee = new Employee();
//    	employee.setDept(dept);
//    	employee.setName(name);
//    	employee.setSalary(salary);
//    	System.out.println(dept);
//    	System.out.println(name);
//    	System.out.println(salary);
        return repository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAzuresqlApplication.class, args);
    }

}
