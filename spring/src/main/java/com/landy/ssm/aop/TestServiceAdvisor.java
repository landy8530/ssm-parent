package com.landy.ssm.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestServiceAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before advice run [ method name : " + method.getName()
				+ " , args : ( " + Arrays.toString(args) + " )"
				+ " , target : " + target
				+ " , target class name : " + target.getClass().getName()
				+ " ] ");
	}

}
