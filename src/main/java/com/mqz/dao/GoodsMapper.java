package com.mqz.dao;

import java.util.List;

import com.mqz.pojo.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsid);

    int insert(GoodsEntity record);

    int insertSelective(GoodsEntity record);

    GoodsEntity selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(GoodsEntity record);

    int updateByPrimaryKey(GoodsEntity record);
    //手动添加
    List<GoodsEntity>  selectAll();

    GoodsEntity selectByTypeId(int goodsid);  //应该是typeid  还是 goodsid???

    GoodsEntity selectByGoodsName(String goodsname);
}