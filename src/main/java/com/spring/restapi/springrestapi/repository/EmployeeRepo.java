package com.spring.restapi.springrestapi.repository;

import com.spring.restapi.springrestapi.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    public Employee getById(int id);

}
