package com.vk.rest.SpringBootRestFulService.Beans;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
@JsonFilter("myFilter")
//@JsonIgnoreProperties(value = {"empId"})
public class Employee {
    String firstName;
    String lastName;
    //ignores the empid in the response
  //      @JsonIgnore
    String empId;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String empId) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
