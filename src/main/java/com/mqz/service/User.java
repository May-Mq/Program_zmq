package com.mqz.service;

import org.springframework.stereotype.Service;

import com.mqz.pojo.UserEntity;

@Service
public interface User {
	UserEntity getUserEntity(int userid);
	int ifLoginByUsername(String username, String password);
}
