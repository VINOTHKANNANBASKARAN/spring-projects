package com.vk.rest.SpringBootRestFulService.Service;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import com.vk.rest.SpringBootRestFulService.Dao.CustomerDao;
import com.vk.rest.SpringBootRestFulService.Exception.CustomerNotFoundException;
import com.vk.rest.SpringBootRestFulService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    EntityManager em;

    @Autowired
    CustomerRepository customerRepository;

    private List<Customer> customersList;

    public List<Customer > getAllCustomer(){
       // return customerDao.getAllCustomer();
       // return customerRepository.findAll();
        System.out.println("Native query");
       customersList = em.createNativeQuery("select * from customers",Customer.class).getResultList();
      // customersList.forEach( customer -> System.out.println(customer.toString()));
        return  customersList;
    }

    public Optional<Customer> getCustomerById(BigDecimal id) {
        return  customerRepository.findById(id);

    }

    public Optional<Customer> updateCustomer(Customer customer) {
        System.out.println("update for customer whose id is "+customer.getCUSTOMER_ID());
        Optional<Customer> oldCustomer = getCustomerById(customer.getCUSTOMER_ID());
        if(oldCustomer.isPresent()){
            if(customer.equals(oldCustomer)){
                System.out.println("Object is the same so no update");
                return oldCustomer;
            }else {
                customerRepository.save(customer);
                System.out.println("Updated completed");
            }

        }else{
            throw new CustomerNotFoundException("id is not found.. so cannot be updated");
        }

        return Optional.of(customer);
    }

    public ResponseEntity<Object> addCustomer(Customer customer) {
        URI Location = null;
        try {
            //Get the sequence and then insert the value
            Query q = em.createNativeQuery("select customer_seq.nextval from dual");

             customer.setCUSTOMER_ID((BigDecimal) q.getSingleResult());
            System.out.println("Inserting " + customer.toString());
            customerRepository.save(customer);
            Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(customer.getCUSTOMER_ID()).toUri();

            System.out.println("Insertion Successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return ResponseEntity.created(Location).build();
        return  ResponseEntity.status(HttpStatus.CREATED).body(Location);
    }

    public void deleteById(BigDecimal id) {
        try {
            customerRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new CustomerNotFoundException("Customer is not found");
        }
    }
}
