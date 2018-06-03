package com.landy.ssm.aop.exception;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:aop/applicationContext.xml");
		
		TestService service = context.getBean("executionService", TestService.class);
		
		System.out.println(service.getClass().getName());
		service.test("test execution");
	}
	
}
