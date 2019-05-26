

package com.spring.demo.TransactionManagementDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.demo.TransactionManagementDemo.UserService.UserService;
import com.spring.demo.TransactionManagementDemo.UserService.Users;

@SpringBootApplication
public class TransactionManagementDemoApplication implements CommandLineRunner{

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
			
			try {
			List<Users> users = new ArrayList<Users>();
		
			for(int i =1; i<5;i++) {
				users.add(new Users("ABC"+new Random().nextInt(10),"Dev",(long) new Random().nextInt(15000)));
			}
			
			userService.insert(users);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(userService.getUsers());
			
		
	}

}
