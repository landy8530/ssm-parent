package com.landy.ssm.mapper;

import com.landy.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

	// 希望是分页查询
	@Select("select id, name, age from t_user")
	public List<User> getUsers(@Param("page") int page, @Param("rows") int rows);
	
}
