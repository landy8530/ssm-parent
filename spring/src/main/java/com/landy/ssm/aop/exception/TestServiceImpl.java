package com.landy.ssm.aop.exception;

import org.springframework.stereotype.Service;

@Service("executionService")
public class TestServiceImpl implements TestService {

	@Override
	@LogAnnotation
	public void test(String str) {
		System.out.println("TestServiceImpl run : " + str);
	}

}
