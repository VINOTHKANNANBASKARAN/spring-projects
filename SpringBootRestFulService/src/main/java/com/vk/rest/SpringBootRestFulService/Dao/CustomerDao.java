package com.vk.rest.SpringBootRestFulService.Dao;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer getCustomerById(String custId);
    public List<Customer> getAllCustomer();
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(String custId);
    public void addCustomer(Customer customer);

}
