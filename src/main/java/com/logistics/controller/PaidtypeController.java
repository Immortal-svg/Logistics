package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Paidtype;
import com.logistics.service.PaidtypeService;
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
@RequestMapping("/paidtype")
public class PaidtypeController {

    @Autowired
    private PaidtypeService paidtypeService;

    //查询所有的付款方式
    @RequestMapping( "/selectpaidAll")
    public String  selectareaall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Paidtype> paidtypePage = paidtypeService.selectPage(new Page<Paidtype>(thispage, 2));
        request.setAttribute("paidtypePage",paidtypePage);

        return "paidTypelist";
    }
    //删除付款方式
    @RequestMapping(value = "/delPaidType")
    public String delArea (Integer paidID){
        paidtypeService.deleteById(paidID);
        return "redirect:/paidtype/selectpaidAll";
    }
    //查询到修改页面
    @RequestMapping(value = "/updPaidType",method = RequestMethod.GET)
    public String updArea(Integer paidID,HttpServletRequest request){
        Paidtype paidtype= paidtypeService.selectById(paidID);
        request.setAttribute("paidtype",paidtype);
        return "paidTypeUpdate" ;
    }
    //确定修改
    @RequestMapping(value = "/updPaidType",method = RequestMethod.POST)
    public String updAreaOk(Paidtype paidtype){
        paidtypeService.updateById(paidtype);
        return "redirect:/paidtype/selectpaidAll";
    }
    //判断付款方式是否存在
    @ResponseBody
    @RequestMapping("/isAreaEixt")
    public Paidtype isAreaEixt(String paidName){
        System.out.println("判断是否运输工具名存在");
        Wrapper<Paidtype> sendWrapper=new EntityWrapper<Paidtype>();
        sendWrapper.eq("paidName",paidName);
        Paidtype paidtype = paidtypeService.selectOne(sendWrapper);
        if(paidtype==null){
            paidtype=new Paidtype();
            return paidtype;
        }
        return paidtype;
    }
    //添加付款方式
    @RequestMapping(value = "/insPaidType")
    public String insArea(Paidtype paidtype){
        paidtypeService.insert(paidtype);
        return "redirect:/paidtype/selectpaidAll";
    }


}

