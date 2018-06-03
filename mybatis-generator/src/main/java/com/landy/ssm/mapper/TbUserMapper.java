package com.landy.ssm.mapper;

import com.landy.ssm.entity.TbUser;
import com.landy.ssm.entity.TbUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
	// 查询数据行数
    long countByExample(TbUserExample example);

    // 删除
    int deleteByExample(TbUserExample example);

    // 主键删除
    int deleteByPrimaryKey(Long id);

    // 新增， 全数据新增。将参数中的所有属性数据保存到数据库
    int insert(TbUser record);

    // 新增，部分数据新增，将参数中对象内的，非默认数据的属性保存到磁盘中。
    int insertSelective(TbUser record);

    // 条件查询
    List<TbUser> selectByExample(TbUserExample example);

    // 主键查询
    TbUser selectByPrimaryKey(Long id);

    // 已example作为更新的条件，record作为要更新的数据，更新数据库中的数据。部分更新。非默认数据属性更新。
    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    // 已example作为更新的条件，record作为要更新的数据，更新数据库中的数据。全数据更新
    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    // 主键作为条件，更新数据。record中非默认数据更新
    int updateByPrimaryKeySelective(TbUser record);

    // 主键作为条件，更新数据。全数据更新。
    int updateByPrimaryKey(TbUser record);
}