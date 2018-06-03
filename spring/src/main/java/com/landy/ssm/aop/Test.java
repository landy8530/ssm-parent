package com.landy.ssm.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				// new ClassPathXmlApplicationContext("classpath:aop/execution/applicationContext.xml");
				// new ClassPathXmlApplicationContext("classpath:aop/within/applicationContext.xml");
				// new ClassPathXmlApplicationContext("classpath:aop/this/applicationContext.xml");
				// new ClassPathXmlApplicationContext("classpath:aop/target/applicationContext.xml");
				new ClassPathXmlApplicationContext("classpath:aop/args/applicationContext.xml");
		
		TestService service = context.getBean("service", TestService.class);
		
		System.out.println(service.getClass().getName());
		service.test("test execution");
	}
	
	public void test(){
		
	}
}
