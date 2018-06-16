package com.mqz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mqz.pojo.GoodsEntity;

public interface Goods{
	int goodsDelete(int goodsid);

    int goodsUpdate(GoodsEntity goods);

    int goodsAdd(GoodsEntity goods);

    List<GoodsEntity> getAllGoods();

    GoodsEntity getGoods(int goodsid);
}
