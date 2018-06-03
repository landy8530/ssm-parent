package com.landy.ssm;

import com.landy.ssm.entity.TbUser;
import com.landy.ssm.entity.TbUserExample;
import com.landy.ssm.entity.TbUserExample.Criteria;
import com.landy.ssm.mapper.TbUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMyBatis {
	
	@Test
	public void testUpdate() throws Exception {
		SqlSession session = this.getSession();
		
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		
		TbUser user = new TbUser();
		user.setId(1L);
		user.setName("abc");
		// 主键更新全部数据字段
		mapper.updateByPrimaryKey(user);
		
		// 主键更新非默认值数据字段。
		mapper.updateByPrimaryKeySelective(user);
		
		TbUserExample example = new TbUserExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(10L);
		// 根据example条件更新全部数据字段
		mapper.updateByExample(user, example);
		// 根据example条件更新非默认值数据字段。
		mapper.updateByExampleSelective(user, example);
		
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testSelect() throws Exception {
		SqlSession session = this.getSession();
		
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		// 主键查询
		mapper.selectByPrimaryKey(1L);
		
		TbUserExample example = new TbUserExample();
		// 排序。
		example.setOrderByClause("id desc");
		// 是否排除重复
		example.setDistinct(true);
		// 查询多少条数据。
		example.setLimit(3);
		// 从第几行开始查询。
		example.setOffset(0);
		Criteria c = example.createCriteria();
		c.andIdBetween(1L, 5L);
		c.andNameLike("_a%");
		
		// 根据example条件查询多数据
		mapper.selectByExample(example);
		
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		SqlSession session = this.getSession();
		
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		// 主键删除
		mapper.deleteByPrimaryKey(1L);
		
		// 模拟Hibernate中的QBE定义的条件。 Example类型。每个实体对应一个Example。每个Example中有有一个Criteria内部类。
		// Criteria内部类用于定义具体条件。约束是只能做and多条件。 所有的条件定义方式为：Criteria.and字段名条件
		// 如： criteria.andIdEqualTo    andNameLike   andIdBetween   andIdIn
		TbUserExample example = new TbUserExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(2L);
		c.andNameLike("%n%");
		c.andPasswordNotEqualTo("123");
		// 根据example条件删除数据
		mapper.deleteByExample(example);
		
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testInsert() throws Exception {
		SqlSession session = this.getSession();
		
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		
		TbUser user = new TbUser();
		user.setName("admin");
		// 新增数据，新增参数中非默认值数据字段
		mapper.insertSelective(user);
		// 新增数据，新增参数中的所有数据字段
		mapper.insert(user);
		
		session.commit();
		
		session.close();
	}
	
	private SqlSession getSession() throws Exception {
		SqlSessionFactory factory = 
				new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("mybatis-cfg.xml")
						);
		
		return factory.openSession();
	}
	
}
