package com.spring.demo.TransactionManagementDemo.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.spring.demo.TransactionManagementDemo.UserService.UserService;
import com.spring.demo.TransactionManagementDemo.UserService.Users;

public class UserRunner implements CommandLineRunner{
	
	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
		
		try {
		List<Users> users = new ArrayList<Users>();
	
		for(int i =1; i<5;i++) {
			users.add(new Users("ABC"+i,"Dev", new Random().nextLong()));
		}
		
		userService.insert(users);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(userService.getUsers());
		
	}

}
