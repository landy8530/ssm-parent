package com.landy.ssm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	
	private static SqlSessionFactory factory;
	
	static{
		try{
			factory = 
				new SqlSessionFactoryBuilder()
					.build(
							Resources.getResourceAsStream("mybatis-cfg.xml")
							);
		}catch(Exception e){
			e.printStackTrace();
			// 静态初始化代码块异常错误
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * @Description 工具方法,创建会话对象使用.
	 * @return 创建的会话对象.
	 */
	public static SqlSession openSession(){
		return factory.openSession();
	}

}
