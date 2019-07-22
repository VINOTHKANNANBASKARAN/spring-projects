package com.vk.rest.SpringBootRestFulService.controller;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import com.vk.rest.SpringBootRestFulService.Exception.CustomerNotFoundException;
import com.vk.rest.SpringBootRestFulService.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "customer", method = RequestMethod.GET)
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/customer/{custId}", method = RequestMethod.GET)
    public Resource<ResponseEntity<Optional<Customer>>> getCustomerById(@PathVariable("custId") BigDecimal id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        //Code to send the URI location as header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        httpHeaders.add("URI", ResponseEntity.created(location).build().toString());
        httpHeaders.add("location", location.toString());

        if (!customer.equals(Optional.empty())) {
            System.out.println("Id fouund" + customer);
            // return new ResponseEntity<>(customer, httpHeaders,HttpStatus.OK);
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK)
                    .header("URI", location.toString())
                    .header("key", "Value")
                    .body(customer);
            Resource<ResponseEntity<Optional<Customer>>> resource =
                    new Resource<ResponseEntity<Optional<Customer>>>(responseEntity);
            ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllCustomer());
            resource.add(linkTo.withRel("Get All customers"));
            return resource;
        } else {
            System.out.println("no id found");
            customer = Optional.of(new Customer());
            customer.get().setCUSTOMER_NAME("Not found");
            //return new ResponseEntity<Optional<Customer>>(customer, httpHeaders,HttpStatus.NOT_FOUND);
           /* return Resource.ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("URI",location.toString()).
                    body(customer);*/
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("URi", location.toString())
                    .body(customer);
            Resource<ResponseEntity<Optional<Customer>>> resource =
                    new Resource<ResponseEntity<Optional<Customer>>>(responseEntity);

            //  ControllerLinkBuilder linkGetCustomerById = linkTo(methodOn(this.getClass()).updateCustomer(customer.get()));
            ControllerLinkBuilder linkDeleteLink = linkTo(methodOn(this.getClass()).deleteById(id));
            ControllerLinkBuilder linkGetAllCustomer = linkTo(methodOn(this.getClass()).getAllCustomer());
            //   resource.add(linkGetCustomerById.withRel("Update Customer"));
            resource.add(linkDeleteLink.withRel("Delete Customer"));
            resource.add(linkGetAllCustomer.withRel("Get All Customers"));
            return resource;


        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Optional<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

        System.out.println("start of update");
        return customerService.updateCustomer(customer);


    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> addCutomer(@Valid @RequestBody Customer customer) {
        // customer.setCUSTOMER_ID(null);
        System.out.println("Started insert to customer");
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable BigDecimal id) throws CustomerNotFoundException {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand().toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("URI", uri.toString());
        httpHeaders.add("Status Code", HttpStatus.OK.toString());


        customerService.deleteById(id);
        return new ResponseEntity<>("Delete successful", httpHeaders, HttpStatus.OK);

    }

    //HATEOAS

}
