package com.landy.ssm.parentcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestParentContainer {
	public static void main(String[] args) {
		ApplicationContext parent = 
				new ClassPathXmlApplicationContext("classpath:parentcontainer/applicationContext.xml");
		/*
		ApplicationContext child = 
				new ClassPathXmlApplicationContext("classpath:parentcontainer/applicationContext2.xml");
		*/
		
		ApplicationContext child = 
				new ClassPathXmlApplicationContext(new String[]{"classpath:parentcontainer/applicationContext2.xml"}, parent);
		
		System.out.println("context1.getBean(\"a\") - " + parent.getBean("a"));
		
		// System.out.println("context1.getBean(\"b\") - " + parent.getBean("b"));
		
		System.out.println("context2.getBean(\"a\") - " + child.getBean("a"));
		
		System.out.println("context2.getBean(\"b\") - " + child.getBean("b"));
	}
}
