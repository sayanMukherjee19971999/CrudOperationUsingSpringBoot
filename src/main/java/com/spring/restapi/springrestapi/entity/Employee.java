package com.spring.restapi.springrestapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empFName;
    private String empLName;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, mappedBy = "emp")
    @JsonManagedReference
    private List<Address> address;

    public Employee() {
    }

    public Employee(int empId, String empFName, String empLName, List<Address> address) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

}
