package com.spring.restapi.springrestapi.controller;

import java.util.List;
import java.util.Optional;

import com.spring.restapi.springrestapi.entity.Employee;
import com.spring.restapi.springrestapi.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        List<Employee> ls = this.employeeService.getAllEmployee();
        if (ls.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ls));
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int id) {
        Employee emp = this.employeeService.getEmployeeById(id);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(Optional.of(emp));
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        Employee e = null;
        try {
            e = this.employeeService.addEmployee(emp);
            return ResponseEntity.status(HttpStatus.CREATED).body(e);
        } catch (Exception e1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") int id) {
        try {
            this.employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("empId") int id) {
        try {
            this.employeeService.updateEmployee(emp, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
