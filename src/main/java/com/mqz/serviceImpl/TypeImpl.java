package com.mqz.serviceImpl;

import com.mqz.dao.GoodsMapper;
import com.mqz.test.SqlsessionDao;
import com.mqz.dao.TypeMapper;
import com.mqz.pojo.GoodsEntity;
import com.mqz.pojo.TypeEntity;
import com.mqz.service.Type;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImpl implements Type{

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int typeAdd(TypeEntity type) {   //商品类别添加
        TypeEntity type1 = typeMapper.selectByTypeName(type.getTypename());
        if(type1==null){
            typeMapper.insert(type);
        }else {
            return 0;
        }
        return 1;
    }

    @Override
    public int typeDelete(int typeid) {    //商品类别删除
        GoodsEntity goodsEntity = goodsMapper.selectByTypeId(typeid);
        if(goodsEntity==null){
            typeMapper.deleteByPrimaryKey(typeid);
        }else{
            return 0;
        }
        return 1;
    }

    @Override
    public int typeUpdate(TypeEntity type) {   //商品类别修改
        return typeMapper.updateByPrimaryKey(type);
    }



    @Override
    public List<TypeEntity> getAllType() {   //获得商品类别列表
        /*SqlSession sqlSession = SqlsessionDao.getSqlsession();
        List<TypeEntity> typeEntities = sqlSession.selectList("TypeMapper.selectAll");
        sqlSession.close();*/
        List<TypeEntity> typeEntities = typeMapper.selectAll();
        return typeEntities;
    }

    @Override
    public TypeEntity getType(String typename) {
        //SqlSession sqlSession = SqlsessionDao.getSqlsession();
        //TypeEntity typeEntity = sqlSession.selectOne("TypeMapper.getTypename",typename);
        return typeMapper.selectByTypeName(typename);
    }


}
