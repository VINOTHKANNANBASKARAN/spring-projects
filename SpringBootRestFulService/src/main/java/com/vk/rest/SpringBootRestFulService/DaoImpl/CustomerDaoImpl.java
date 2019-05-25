package com.vk.rest.SpringBootRestFulService.DaoImpl;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import com.vk.rest.SpringBootRestFulService.Dao.CustomerDao;
import com.vk.rest.SpringBootRestFulService.Mapper.CustomerMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    Logger logger = LogManager.getLogger(CustomerDaoImpl.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Customer getCustomerById(String custId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customersList = null;

        try {

            customersList = jdbcTemplate.query("select * from customers", new CustomerMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return customersList;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(String custId) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }

}
