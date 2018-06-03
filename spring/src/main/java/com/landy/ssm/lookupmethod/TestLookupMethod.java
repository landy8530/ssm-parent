package com.landy.ssm.lookupmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLookupMethod {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:lookupmethod/applicationContext.xml");
		
		CommandManager manager = context.getBean("manager", CommandManager.class);
		
		System.out.println(manager.getClass().getName());
		manager.process();
	}
}

abstract class CommandManager{
	public void process() {
		MyCommand command = createCommand();
        // do something ...
		System.out.println(command);
    }

    protected abstract MyCommand createCommand();
}

interface MyCommand{
}

class MyCommand1 implements MyCommand{
	public MyCommand1(){
		System.out.println("MyCommand1 instanced");
	}
}

class MyCommand2 implements MyCommand{
	public MyCommand2(){
		System.out.println("MyCommand2 instanced");
	}
}