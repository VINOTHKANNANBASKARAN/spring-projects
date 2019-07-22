package com.vk.rest.SpringBootRestFulService.Mapper;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        Customer customer = new Customer();
        customer.setCUSTOMER_ID(resultSet.getBigDecimal("CUSTOMER_ID"));
        customer.setCUSTOMER_NAME(resultSet.getString("CUSTOMER_NAME"));
        customer.setMOBILENUMBER(resultSet.getString("MOBILENUMBER"));
        customer.setCITY(resultSet.getString("CITY"));
        customer.setDOB(resultSet.getDate("DOB"));
        customer.setDOJ(resultSet.getDate("DOJ"));
        customer.setCRT_TS(resultSet.getTimestamp("CRT_TS"));
        customer.setCREDITLIMIT(resultSet.getBigDecimal("CREDITLIMIT"));

        return customer;
    }
}
