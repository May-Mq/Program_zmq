package com.mqz.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mqz.serviceImpl.GoodsImpl;
import com.mqz.serviceImpl.TypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mqz.pojo.GoodsEntity;
import com.mqz.pojo.TypeEntity;
import com.mqz.service.Goods;


@Controller
@RequestMapping(value="/goods")

public class GoodsController{
	@Autowired
    private Goods goodsService;
	@Autowired
    GoodsImpl goodsImpl;
    @Autowired
    TypeImpl typeImpl;

	//goodsList �鿴��Ʒ��Ϣ�б�
	@RequestMapping(value="/goodslist")
    public String getGoodsList(HttpServletRequest request,HttpServletResponse response){
	    //���ı�������
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        List<GoodsEntity> list = goodsService.getAllGoods();
        request.setAttribute("goods",list);
        return "goods_manager";
    }
	
	//goodsAdd  ������Ʒ��Ϣ
	@RequestMapping(value="/goodsAdd")
    public ModelAndView goodsAdd(GoodsEntity goodsEntity,HttpServletRequest request,HttpServletResponse response){
        //���ı�������
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        int addResult = goodsService.goodsAdd(goodsEntity);
        System.out.println("GoodsAddContro:"+addResult);
        ModelAndView modelAndView = new ModelAndView();
        if(addResult > 0){
            modelAndView.setViewName("redirect:/goods/goodslist");
        }
        else{
            modelAndView.setViewName("fail");
            System.out.println("��Ʒ���ʧ��"); 
            modelAndView.setViewName("goods_add");
        }
        return modelAndView;
    }


	//goodsDelete    ɾ����Ʒ��Ϣ
    @RequestMapping(value="/goodsDelete/{goodsid}")
    public ModelAndView goodsDelete(@PathVariable int goodsid,HttpServletRequest request,HttpServletResponse response){
        //���ı�������
	    try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        int deleteResult = goodsService.goodsDelete(goodsid);
        ModelAndView modelAndView = new ModelAndView();
        if(deleteResult>0){
            modelAndView.setViewName("redirect:/goods/goodslist");
        }
        else{
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }

    //goodsUpdate  �޸���Ʒ��Ϣ
    @RequestMapping(value="/goodsUpdate/{goodsid}")
    public ModelAndView goodsUpdate(@PathVariable int goodsid,HttpServletRequest request,HttpServletResponse response){
        //���ı�������
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

    	GoodsEntity goodsEntity = goodsService.getGoods(goodsid);
        ModelAndView modelAndView = new ModelAndView("goods_update");
        modelAndView.addObject(goodsEntity);
        return modelAndView;
    }

    //goodsSave  ��Ʒ��Ϣ�޸�֮�󱣴�
    @RequestMapping(value="/goodssave")
    public ModelAndView doSave(GoodsEntity goodsEntity,HttpServletRequest request,HttpServletResponse response){
        //���ı�������
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        System.out.println("controller����"+goodsEntity.getGoodsid());
        System.out.println(goodsEntity.getGoodsnum());
        System.out.println(goodsEntity.getGoodstype());
       // int a=goodsService.goodsUpdate(goodsEntity);
        int a=goodsImpl.goodsUpdate(goodsEntity);

        System.out.println(a);
        return new ModelAndView("redirect:/goods/goodslist");
    }


    //to goodsAdd ��ת������Ʒ��Ϣ
    @RequestMapping(value="/toGoodsAdd")
    public String toGoodsAdd(HttpServletRequest request){
	    //List<String> listType = new ArrayList<>();
        return "goods_add";
    }
    


    //    public ModelAndView getItem(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<GoodsEntity> goodsEntityList = goodsService.getAllGoods();
//        modelAndView.setViewName("goods");
//        modelAndView.addObject(goodsEntityList);
//        return modelAndView;
//    }

}
