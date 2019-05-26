package com.spring.demo.TransactionManagementDemo.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service	
public class UserService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Transactional
	public void insert(List<Users> users) {
		
		System.out.println("Inserting data for user");
		users.stream().forEach(a->jdbcTemplate.update("Insert into USER (Name, dept, salary) values (?,?,?)",
				preparedStatementSetter->{
					System.out.println("Inserting data for user:"+a.getName());
					preparedStatementSetter.setString( 1, a.getName());
					preparedStatementSetter.setString(2, a.getDept());
					preparedStatementSetter.setLong(3, a.getSalary());
				}));
	}
	
	public List<Users>  getUsers(){
		System.out.println("retrive all user list");
		List<Users> usersList = jdbcTemplate.query("select Name, dept, salary from USER", ( rs,  arg1) -> {
				// TODO Auto-generated method stub
				Users user = new Users(rs.getString("Name"),
						rs.getString("dept"),
						rs.getLong("salary"));
				
				return user;			
		});
		
		return usersList;
		
	}
	
}
