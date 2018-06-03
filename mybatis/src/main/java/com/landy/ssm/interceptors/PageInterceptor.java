package com.landy.ssm.interceptors;

import com.landy.ssm.entity.User;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.*;

/*
 * @Intercepts注解。代表当前的类型是一个MyBatis的拦截器。 必要的注解。其中有必要属性是一个数组类型的属性。
 * 数组的类型是@Signature
 * @Signature注解。要拦截的内容。
 * method - query 对应 statement中的executeQuery方法。   update 对应 statement中的executeUpdate方法。
 * type - 拦截的驱动的类型。 Executor是MyBatis底层访问数据库时封装的操作接口。类似JDBC中的Statement。
 * args - 通知MyBatis框架，当前的拦截器中拦截方法intercept参数invocation需要提供多少个参数。
 */
@Intercepts(
		{
			@Signature(method="query", type=Executor.class, args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
		}
)
public class PageInterceptor implements Interceptor {
	
	private String dialect;

	public Object intercept(Invocation invocation) throws Throwable {
		
		// 获取参数数据。就是注解中args配置的信息。
		Object[] args = invocation.getArgs();
		System.out.println("args : " + Arrays.toString(args));
		// 获取映射处理器。
		MappedStatement statement = (MappedStatement) args[0];
		// 拦截的方法的参数表。
		Object parameter = args[1];
		// 结果处理器。 就是查询结果处理器。类似封装好的一个ResultSet
		ResultHandler handler = (ResultHandler)args[3];
		// 获取拦截的方法。
		Method method = invocation.getMethod();
		System.out.println("method : " + method);
		
		// 获取执行器。类似JDBC中的Statement。
		Executor target = (Executor) invocation.getTarget();
		System.out.println("target : " + target);
		
		// 通过MappedStatement获取的SQL语句。可以是XML中配置的SQL或注解中定义的SQL。
		BoundSql bSql = statement.getBoundSql(parameter);
		System.out.println(bSql.getSql());
		
		String pageSql = this.toPageSql(bSql.getSql(), parameter);
		
		System.out.println(pageSql);
		
		// 定义一个新的SQL。 用于替换拦截的方法要执行的SQL。
		BoundSql pageBoundSql = new BoundSql(statement.getConfiguration(), pageSql, bSql.getParameterMappings(), parameter);

		// 是一个缓存。 当执行查询后，会将查询结果缓存到一级缓存中。
		CacheKey cacheKey = target.createCacheKey(statement, parameter, RowBounds.DEFAULT, pageBoundSql);
		
		List<User> temp = target.query(statement, parameter, RowBounds.DEFAULT, handler, cacheKey, pageBoundSql);
		
		return temp;
	}
	
	private String toPageSql(String sql, Object parameter){
		Map<String, Object> paramMap = this.transParameter(parameter);
		
		StringBuilder builder = new StringBuilder();
		builder.append(sql);
		builder.append(" limit ").append(paramMap.get("start"))
				.append(", ").append(paramMap.get("limit"));
		return builder.toString();
	}
	
	private Map<String, Object> transParameter(Object parameter){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(parameter instanceof Map){
			
			Map<String, Object> sourceParam = (Map<String, Object>) parameter;
			int page = Integer.parseInt(sourceParam.get("page").toString());
			int rows = Integer.parseInt(sourceParam.get("rows").toString());
			paramMap.put("start", (page-1)*rows);
			paramMap.put("limit", rows);
			
			return paramMap;
		}else{
			return null;
		}
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		this.setDialect(properties.getProperty("dialect"));
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

}
