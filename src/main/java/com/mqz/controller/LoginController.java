package com.mqz.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mqz.dao.UserMapper;
import com.mqz.service.User;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
public class LoginController {
	@Autowired
	User user;
	
	//判断是否已登录
    @RequestMapping("/login")
        public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int loginResult = user.ifLoginByUsername(username, password);
        if(loginResult==0){
        	System.out.println("请输入正确的用户名和密码登录系统");
        	return new ModelAndView("login");
        }
        else{
        	HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return new ModelAndView("home_page");
        }

    }
        
      //退出登录
        @RequestMapping("/outlogin")
        public String outlogin(HttpServletRequest request){
            HttpSession session = request.getSession();
            session.setAttribute("username",null);
            return "login";
        }
    }

