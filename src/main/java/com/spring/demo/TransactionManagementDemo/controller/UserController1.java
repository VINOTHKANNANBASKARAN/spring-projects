package com.spring.demo.TransactionManagementDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.TransactionManagementDemo.UserService.UserService;
import com.spring.demo.TransactionManagementDemo.UserService.Users;

@RestController
@RequestMapping("controller1")
public class UserController1 {
	// this ia trial methods
	@Autowired
	UserService service;
	
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public List<Users> getUser() {
		return service.getUsers();
	}
	
	
}
