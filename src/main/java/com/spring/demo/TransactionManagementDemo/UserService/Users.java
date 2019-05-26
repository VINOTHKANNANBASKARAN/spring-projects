package com.spring.demo.TransactionManagementDemo.UserService;

import org.springframework.stereotype.Component;

@Component
public class Users {

		String name;
		String dept;
		Long salary;
		
		
		public Users(String name, String dept, Long salary) {
			super();
			this.name = name;
			this.dept = dept;
			this.salary = salary;
		}
		public Users() {
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public Long getSalary() {
			return salary;
		}
		public void setSalary(Long salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Users [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
		}
		
}
