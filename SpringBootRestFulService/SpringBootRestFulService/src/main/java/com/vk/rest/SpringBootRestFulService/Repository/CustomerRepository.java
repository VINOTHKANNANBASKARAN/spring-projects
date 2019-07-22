package com.vk.rest.SpringBootRestFulService.Repository;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {



}
