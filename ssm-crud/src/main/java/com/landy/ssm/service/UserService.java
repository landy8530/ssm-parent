package com.landy.ssm.service;

import com.landy.ssm.commons.ResultMessage;
import com.landy.ssm.pojo.User;

public interface UserService {

	ResultMessage addUser(User user);
	ResultMessage modifyUser(User user);
	ResultMessage deleteUser(User user);
	ResultMessage listUsers(int page, int rows);
	ResultMessage getUserById(Long id);
	
}
