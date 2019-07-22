package com.vk.rest.SpringBootRestFulService.Beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@ApiModel(description = "Customer object  ")
@Entity
@NamedNativeQueries({
@NamedNativeQuery(name = "findAll.Customer",query = "select c from customers c")})
@Table(name="customers")
public class Customer {

    @Id
    @ApiModelProperty(notes = "customer id cannot be nullabe")
    @Column(name = "CUSTOMER_ID")
    private BigDecimal CUSTOMER_ID;

    @Size(min = 5 )
    @Column(name = "CUSTOMER_NAME")
    String CUSTOMER_NAME;
    @Column(name = "CITY")
    String CITY;


    String MOBILENUMBER;

    @ApiModelProperty(notes = "should be in the past older than 320 years")
    Date DOB;
    Date DOJ;
    Timestamp CRT_TS;
    BigDecimal CREDITLIMIT;


    public Customer(String CUSTOMER_NAME, String CITY, String MOBILENUMBER, Date DOB, Date DOJ, Timestamp CRT_TS, BigDecimal CREDITLIMIT) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.CITY = CITY;
        this.MOBILENUMBER = MOBILENUMBER;
        this.DOB = DOB;
        this.DOJ = DOJ;
        this.CRT_TS = CRT_TS;
        this.CREDITLIMIT = CREDITLIMIT;
    }

    public Customer() {
    }

    public BigDecimal getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(BigDecimal CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getMOBILENUMBER() {
        return MOBILENUMBER;
    }

    public void setMOBILENUMBER(String MOBILENUMBER) {
        this.MOBILENUMBER = MOBILENUMBER;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getDOJ() {
        return DOJ;
    }

    public void setDOJ(Date DOJ) {
        this.DOJ = DOJ;
    }

    public Timestamp getCRT_TS() {
        return CRT_TS;
    }

    public void setCRT_TS(Timestamp CRT_TS) {
        this.CRT_TS = CRT_TS;
    }

    public BigDecimal getCREDITLIMIT() {
        return CREDITLIMIT;
    }

    public void setCREDITLIMIT(BigDecimal CREDITLIMIT) {
        this.CREDITLIMIT = CREDITLIMIT;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "CUSTOMER_ID='" + CUSTOMER_ID + '\'' +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                ", CITY='" + CITY + '\'' +
                ", MOBILENUMBER='" + MOBILENUMBER + '\'' +
                ", DOB='" + DOB + '\'' +
                ", DOJ='" + DOJ + '\'' +
                ", CRT_TS=" + CRT_TS +
                ", CREDITLIMIT=" + CREDITLIMIT +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return CUSTOMER_ID.equals(customer.CUSTOMER_ID) &&
                CUSTOMER_NAME.equals(customer.CUSTOMER_NAME) &&
                Objects.equals(CITY, customer.CITY) &&
                Objects.equals(MOBILENUMBER, customer.MOBILENUMBER) &&
                Objects.equals(DOB, customer.DOB) &&
                Objects.equals(DOJ, customer.DOJ) &&
                Objects.equals(CRT_TS, customer.CRT_TS) &&
                Objects.equals(CREDITLIMIT, customer.CREDITLIMIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CUSTOMER_ID, CUSTOMER_NAME, CITY, MOBILENUMBER, DOB, DOJ, CRT_TS, CREDITLIMIT);
    }
}
