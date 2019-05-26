package com.spring.demo.TransactionManagementDemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


public class AspectTest {
	
	@Before("execution(* com.spring.demo.TransactionManagementDemo.UserService.*.*())")

	public void before(JoinPoint joinPoint) {
		System.out.println("##################### Before Calling "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.spring.demo.TransactionManagementDemo.UserService.*.*())")
	public void after(JoinPoint joinPoint) {
		System.out.println("After Method");
	}
	
	@Around("execution(* com.spring.demo.TransactionManagementDemo.UserService.*.*())")
	public void after(ProceedingJoinPoint joinPoint) {
		System.out.println("Around"+joinPoint);
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("$$$$$$$$After executin join point"+joinPoint.getArgs());
	}
	
	@AfterReturning(pointcut = "execution(* com.spring.demo.TransactionManagementDemo.UserService.*.*())",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("After After Returning"+result);
	}
	
	
}
