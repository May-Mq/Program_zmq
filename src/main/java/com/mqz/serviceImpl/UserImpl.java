package com.mqz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mqz.dao.UserMapper;
import com.mqz.pojo.UserEntity;
import com.mqz.service.User;

@Service
public class UserImpl implements User{
	
	@Autowired
    private UserMapper userMapper;
	
	@Override
	public UserEntity getUserEntity(int userid) {     //登录用户
		UserEntity userEntity = userMapper.selectByPrimaryKey(userid);
        if(userEntity!=null){
            return userEntity;
        }
		return null;
	}

	@Override
	public int ifLoginByUsername(String username, String password) {    //是否登录
		UserEntity userEntity = userMapper.selectByNameAndPwd(username,password);
        if(userEntity!=null){
            return 1;
        }
		return 0;
	}
	

}
