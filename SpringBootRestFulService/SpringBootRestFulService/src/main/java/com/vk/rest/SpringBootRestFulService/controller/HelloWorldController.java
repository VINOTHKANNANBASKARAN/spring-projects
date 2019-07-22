package com.vk.rest.SpringBootRestFulService.controller;

import com.vk.rest.SpringBootRestFulService.Beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/hello", method = RequestMethod.GET,consumes = "application/json")
    public String helloWorld(){
        return  "Hello world";
    }

    @RequestMapping(value = "/hello-internalization", method = RequestMethod.GET,consumes = "application/json")
    public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language",required = false  ) Locale locale){
        return  messageSource.getMessage("Good.morning.message", null,locale);
    }

    @RequestMapping(value = "/hello-bean", method = RequestMethod.GET,produces = "application/json")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("hello world bean");
    }

    @RequestMapping(value = "/hello-bean/{name}", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Object> helloWorldGetParam(@PathVariable String name){
        if(name.equalsIgnoreCase("vinoth")){
          return ResponseEntity.status(HttpStatus.OK).body("Name is Vinoth");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HelloWorldBean(name));
        }
    }
}

