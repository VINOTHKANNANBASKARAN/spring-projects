package com.vk.rest.SpringBootRestFulService.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vk.rest.SpringBootRestFulService.Beans.Employee;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FiltterController {

    @RequestMapping(value = "/emp",method = RequestMethod.GET )
    public Employee returnemployee(){
        return  new Employee("vinoth","kannan","15244");
    }

    @GetMapping("/emp-dyFilter")
    public MappingJacksonValue dynamicFiltering(){
        Employee employee = new Employee("prasanth ","Baskaran","10000");

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("empId");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter",simpleBeanPropertyFilter);

        MappingJacksonValue filters = new MappingJacksonValue(employee);
        filters.setFilters(filterProvider);

        return  filters;
    }

    @GetMapping("/emp-otherFilter")
    public MappingJacksonValue dynamicFilteringOtherWay(){
        Employee employee = new Employee("prasanth ","Baskaran","10000");

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("lastName");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter",simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee);
        mappingJacksonValue.setFilters(filterProvider);
        return  mappingJacksonValue;
    }
}
