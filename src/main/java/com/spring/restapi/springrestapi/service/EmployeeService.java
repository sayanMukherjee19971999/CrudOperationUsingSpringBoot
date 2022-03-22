package com.spring.restapi.springrestapi.service;

import java.util.List;

import com.spring.restapi.springrestapi.entity.Employee;
import com.spring.restapi.springrestapi.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        List<Employee> ls = (List<Employee>) this.employeeRepo.findAll();
        return ls;
    }

    public Employee getEmployeeById(int id) {
        Employee emp = null;
        try {
            emp = (Employee) this.employeeRepo.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void updateEmployee(Employee e, int id) {
        e.setEmpId(id);
        this.employeeRepo.save(e);
    }

    public void deleteEmployee(int id) {
        this.employeeRepo.deleteById(id);
    }

    public Employee addEmployee(Employee e) {
        Employee emp = this.employeeRepo.save(e);
        return emp;
    }
}
