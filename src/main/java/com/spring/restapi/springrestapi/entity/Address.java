package com.spring.restapi.springrestapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {
    @Id
    private int pinCode;
    private String street;
    private String city;
    private String district;
    private String state;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    @JsonBackReference
    private Employee emp;

    public Address() {
    }

    public Address(int pinCode, String street, String city, String district, String state, Employee emp) {
        this.pinCode = pinCode;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.emp = emp;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

}
