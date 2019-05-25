package com.vk.rest.SpringBootRestFulService.Beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CustomerAddress {
    String customerId;
    String customerStreetAddress1;
    String customerStreetAddress2;
    String customerCity;
    String customerState;
    String customerPostalCode;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerStreetAddress1() {
        return customerStreetAddress1;
    }

    public void setCustomerStreetAddress1(String customerStreetAddress1) {
        this.customerStreetAddress1 = customerStreetAddress1;
    }

    public String getCustomerStreetAddress2() {
        return customerStreetAddress2;
    }

    public void setCustomerStreetAddress2(String customerStreetAddress2) {
        this.customerStreetAddress2 = customerStreetAddress2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "customerId='" + customerId + '\'' +
                ", customerStreetAddress1='" + customerStreetAddress1 + '\'' +
                ", customerStreetAddress2='" + customerStreetAddress2 + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerState='" + customerState + '\'' +
                ", customerPostalCode='" + customerPostalCode + '\'' +
                '}';
    }
}
