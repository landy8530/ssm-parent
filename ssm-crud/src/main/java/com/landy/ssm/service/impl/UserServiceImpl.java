package com.landy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landy.ssm.commons.EasyUIDataGrid;
import com.landy.ssm.commons.ResultMessage;
import com.landy.ssm.mapper.UserMapper;
import com.landy.ssm.pojo.User;
import com.landy.ssm.pojo.UserExample;
import com.landy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ResultMessage addUser(User user) {
		
		int count = 0;
		try{
			count = this.userMapper.insert(user);
		}catch(Exception e){
			// 数据库访问错误。
			return ResultMessage.error();
		}
		
		if(count != 1){
			return ResultMessage.error();
		}
		
		return ResultMessage.ok();
	}

	@Override
	public ResultMessage modifyUser(User user) {
		int count = this.userMapper.updateByPrimaryKey(user);
		
		if(count != 1){
			return ResultMessage.error();
		}
		
		return ResultMessage.ok();
	}

	@Override
	public ResultMessage deleteUser(User user) {
		int count = this.userMapper.deleteByPrimaryKey(user.getId());
		
		if(count != 1){
			return ResultMessage.error();
		}
		
		return ResultMessage.ok();
	}

	@Override
	public ResultMessage listUsers(int page, int rows) {
		PageHelper.startPage(page, rows);
		
		UserExample example = new UserExample();
		
		List<User> userList = this.userMapper.selectByExample(example);
		
		PageInfo<User> infos = new PageInfo<>(userList);
		
		EasyUIDataGrid<User> pageInfo = new EasyUIDataGrid<>(infos.getTotal(), userList);
		
		return ResultMessage.ok(pageInfo);
	}

	@Override
	public ResultMessage getUserById(Long id) {
		
		User user = this.userMapper.selectByPrimaryKey(id);
		if(null == user){
			return ResultMessage.error();
		}
		
		return ResultMessage.ok(user);
	}

}
