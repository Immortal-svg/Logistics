package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Customertype;
import com.logistics.service.CustomertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/customertype")
public class CustomertypeController {
    @Autowired
    private CustomertypeService customertypeService;

    //查询所有的客户类型
    @RequestMapping( "/selectCustomertypeAll")
    public String  selectareaall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Customertype> customertypePage = customertypeService.selectPage(new Page<Customertype>(thispage, 2));
        request.setAttribute("customertypePage",customertypePage);

        return "custtypelist";
    }
    //删除客户类型
    @RequestMapping(value = "/delSendType")
    public String delArea (Integer customerTypeID){
        System.out.println("客户类型的id"+customerTypeID);
        customertypeService.deleteById(customerTypeID);
        return "redirect:/customertype/selectCustomertypeAll";
    }
    //查询到修改页面
    @RequestMapping(value = "/updSendType",method = RequestMethod.GET)
    public String updArea(Integer customerTypeID,HttpServletRequest request){
        Customertype customertype= customertypeService.selectById(customerTypeID);
        request.setAttribute("customertype",customertype);
        return "custTypeUpdate" ;
    }
    //确定修改
    @RequestMapping(value = "/updSendType",method = RequestMethod.POST)
    public String updAreaOk(Customertype customertype){
        customertypeService.updateById(customertype);
        return "redirect:/customertype/selectCustomertypeAll";
    }
    //判断客户类型名是否存在
    @ResponseBody
    @RequestMapping("/isAreaEixt")
    public Customertype isAreaEixt(String customerTypeName){
        System.out.println("判断是否运输工具名存在");
        Wrapper<Customertype> sendWrapper=new EntityWrapper<Customertype>();
        sendWrapper.eq("customerTypeName",customerTypeName);
        Customertype customertype = customertypeService.selectOne(sendWrapper);
        if(customertype==null){
            customertype=new Customertype();
            return customertype;
        }
        return customertype;
    }
    //添加客户类型
    @RequestMapping(value = "/insSendType")
    public String insArea(Customertype customertype){
        customertypeService.insert(customertype);
        return "redirect:/customertype/selectCustomertypeAll";
    }

}

