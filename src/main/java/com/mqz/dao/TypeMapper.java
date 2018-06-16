package com.mqz.dao;

import java.util.List;

import com.mqz.pojo.TypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(TypeEntity record);

    int insertSelective(TypeEntity record);

    TypeEntity selectByPrimaryKey(String typename);

    int updateByPrimaryKeySelective(TypeEntity record);

    int updateByPrimaryKey(TypeEntity record);
    
    //手动增加
    List<TypeEntity> selectAll();

    TypeEntity selectByTypeName(String typename);
}