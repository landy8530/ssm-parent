package com.landy.ssm.mapper;

import com.landy.ssm.entity.TbText;
import com.landy.ssm.entity.TbTextExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTextMapper {
    long countByExample(TbTextExample example);

    int deleteByExample(TbTextExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbText record);

    int insertSelective(TbText record);

    List<TbText> selectByExampleWithBLOBs(TbTextExample example);

    List<TbText> selectByExample(TbTextExample example);

    TbText selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbText record, @Param("example") TbTextExample example);

    int updateByExampleWithBLOBs(@Param("record") TbText record, @Param("example") TbTextExample example);

    int updateByExample(@Param("record") TbText record, @Param("example") TbTextExample example);

    int updateByPrimaryKeySelective(TbText record);

    int updateByPrimaryKeyWithBLOBs(TbText record);

    int updateByPrimaryKey(TbText record);
}