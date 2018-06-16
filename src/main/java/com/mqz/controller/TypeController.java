package com.mqz.controller;

import com.mqz.pojo.TypeEntity;
import com.mqz.service.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value="/type_value")

public class TypeController {
    @Resource
    private Type type;

    // typeAdd  新增商品类别列表
    @RequestMapping("/typeAdd")
    public ModelAndView typeAdd(TypeEntity typeEntity,HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        ModelAndView modelAndView = new ModelAndView();
        int addResult = type.typeAdd(typeEntity);
        if(addResult > 0 ){
            modelAndView.setViewName("redirect:/type_value/type_list");
        }
        else{
            modelAndView.setViewName("fail");
        }
        return modelAndView;

    }

    // typeDelete     删除商品类别列表
    @RequestMapping("/typeDelete/{typeid}")
    public ModelAndView deleteType(@PathVariable Integer typeid,HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        ModelAndView modelAndView = new ModelAndView();
        int deleteResult = type.typeDelete(typeid);
        if(deleteResult>0){
            modelAndView.setViewName("redirect:/type_value/type_list");
        }
        else{
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }


    //typeUpdate   修改商品类别列表
    @RequestMapping("/typeUpdate/{typeName}")
    public ModelAndView typeUpdate(@PathVariable String typeName,HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        TypeEntity typeEntity = type.getType(typeName);
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        //request.setAttribute(typeName,typeEntity);
        ModelAndView modelAndView = new ModelAndView("type_update");
        modelAndView.addObject(typeEntity);    //将typeEntity这个对象加进去，jsp中可以使用这个对象的方法
        return modelAndView;
    }


    // getAllType  查看商品类别列表
    @RequestMapping("/type_list")
    public String getTypeList(HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<TypeEntity> list = type.getAllType();
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("type",list);
        return "type_manager";
    }

    //to typeAdd  跳转新增商品类别列表
    @RequestMapping("/toTypeAdd")
    public String toTypeAdd(){
        return "type_add";
    }

    //typeSave  保存修改商品类别
    @RequestMapping("/save")
    public ModelAndView doTypeSave(TypeEntity typeEntity,HttpServletRequest request,HttpServletResponse response){
        //中文编码设置
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        type.typeUpdate(typeEntity);
        return new ModelAndView("redirect:/type_value/type_list");
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("redirect:/type_value/type_list");
    }
}


