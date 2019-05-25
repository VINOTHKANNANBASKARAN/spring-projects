package com.spring.demo.TransactionManagementDemo.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.TransactionManagementDemo.UserService.UserService;
import com.spring.demo.TransactionManagementDemo.UserService.Users;

@RestController
@RequestMapping(value = "controller2")
public class UserController2 {

	@Autowired
	UserService service;

	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public List<Users> getUser() {
		return service.getUsers();
	}
	
	
}
