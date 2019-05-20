package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Sendtype;
import com.logistics.service.SendtypeService;
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
@RequestMapping("/sendtype")
public class SendtypeController {

    @Autowired
    private SendtypeService sendtypeService;

    //查询所有的运输工具
    @RequestMapping( "/selectAllsendtype")
    public String  selectareaall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Sendtype> Sendtypepage = sendtypeService.selectPage(new Page<Sendtype>(thispage, 2));
        request.setAttribute("Sendtypepage",Sendtypepage);

        return "sendTypelist";
    }
    //删除运输工具
    @RequestMapping(value = "/delSendType")
    public String delArea (Integer sendTypeID){
        sendtypeService.deleteById(sendTypeID);
        return "redirect:/sendtype/selectAllsendtype";
    }
    //查询到修改页面
    @RequestMapping(value = "/updSendType",method = RequestMethod.GET)
    public String updArea(Integer sendTypeID,HttpServletRequest request){
        Sendtype sendtype= sendtypeService.selectById(sendTypeID);
        request.setAttribute("sendtype",sendtype);
        return "sendTypeUpdate" ;
    }
    //确定修改
    @RequestMapping(value = "/updSendType",method = RequestMethod.POST)
    public String updAreaOk(Sendtype sendtype){
        sendtypeService.updateById(sendtype);
        return "redirect:/sendtype/selectAllsendtype";
    }
    //判断运输工具名是否存在
    @ResponseBody
    @RequestMapping("/isAreaEixt")
    public Sendtype isAreaEixt(String sendTypeName){
        System.out.println("判断是否运输工具名存在");
        Wrapper<Sendtype> sendWrapper=new EntityWrapper<Sendtype>();
        sendWrapper.eq("sendTypeName",sendTypeName);
        Sendtype sendtype = sendtypeService.selectOne(sendWrapper);
        if(sendtype==null){
            sendtype=new Sendtype();
            return sendtype;
        }
        return sendtype;
    }
    //添加运输工具
    @RequestMapping(value = "/insSendType")
    public String insArea(Sendtype sendtype){
        sendtypeService.insert(sendtype);
        return "redirect:/sendtype/selectAllsendtype";
    }

}

