package com.mqz.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mqz.dao.GoodsMapper;
import com.mqz.dao.TypeMapper;
import com.mqz.pojo.GoodsEntity;
import com.mqz.pojo.TypeEntity;
import com.mqz.service.Goods;

@Service
public class GoodsImpl implements Goods{

	@Autowired
    private GoodsMapper goodsMapper;
	@Autowired
    private TypeMapper typeMapper;
	
	@Override
	public int goodsDelete(int goodsid) {  //商品信息删除
		int deleteResult = goodsMapper.deleteByPrimaryKey(goodsid);
        return deleteResult;
	}

	@Override
	public int goodsUpdate(GoodsEntity goods) {   //商品信息修改
		System.out.println(goods.getGoodsnum());
		System.out.println(goods.getGoodsid());
		int updateResult = goodsMapper.updateByPrimaryKey(goods);
        return updateResult;
	}

	@Override
	public int goodsAdd(GoodsEntity goods) {    //商品信息添加
		GoodsEntity goods1 = goodsMapper.selectByGoodsName(goods.getGoodsname());
       // TypeEntity type = typeMapper.selectByPrimaryKey(goods.getGoodstype());
        if(goods1==null){
			goodsMapper.insert(goods);
		}
		else
			return 0;
//		if(goods1==null && type!=null){
//			goodsMapper.insert(goods);
//		}
//		if(goods1==null || type!=null){
//			return 0;
//		}
        return 1;
	}



	@Override
	public GoodsEntity getGoods(int goodsid) {
		return goodsMapper.selectByPrimaryKey(goodsid);
	}
	
	
	@Override
	public List<GoodsEntity> getAllGoods() {
		List<GoodsEntity> goodsList = goodsMapper.selectAll();
//        List<GoodsEntity> goodsEntity1 = new ArrayList<GoodsEntity>();
//        for(GoodsEntity goodsEntity2 : goodsList){
//        	GoodsEntity goodsEntity = new GoodsEntity();
//        	goodsEntity.setGoodsid(goodsEntity2.getGoodsid());
//        	goodsEntity.setGoodsname(goodsEntity2.getGoodsname());
//        	goodsEntity.setGoodsprice(goodsEntity2.getGoodsprice());
//        	goodsEntity.setGoodsnum(goodsEntity2.getGoodsnum());
//        	goodsEntity.setGoodstype(typeMapper.selectByPrimaryKey(goodsEntity.getGoodstype()));
//        	goodsEntity1.add(goodsEntity);
//        }
//        return goodsEntity1;
//	}
		return  goodsList;
	}
}
