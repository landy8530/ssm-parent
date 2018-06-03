package com.landy.ssm.controller;

import com.landy.ssm.commons.EasyUIDatagrid;
import com.landy.ssm.commons.ResultMessage;
import com.landy.ssm.pojo.User;
import com.landy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/addUser")
	@ResponseBody
	public ResultMessage addUser(User user){
		return this.userService.addUser(user);
	}
	
	@RequestMapping("/user/modifyUser")
	@ResponseBody
	public ResultMessage modifyUser(User user){
		return this.userService.modifyUser(user);
	}
	
	@RequestMapping("/user/getUser4Modify")
	@ResponseBody
	public User getUser4Modify(Long id){
		ResultMessage result =  this.userService.getUserById(id);
		if(result.getStatus() != 200){
			return null;
		}
		return (User) result.getData();
	}
	
	@RequestMapping("/user/deleteUser")
	@ResponseBody
	public ResultMessage deleteUser(User user){
		return this.userService.deleteUser(user);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/user/listUsers")
	@ResponseBody
	public EasyUIDatagrid<User> listUsers(int page, int rows){
		ResultMessage result = this.userService.listUsers(page, rows);
		
		if(result.getStatus() != 200){
			return new EasyUIDatagrid<User>();
		}
		
		return (EasyUIDatagrid<User>)result.getData();
	}
	
}
