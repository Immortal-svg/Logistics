package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Orderstatus;
import com.logistics.service.OrderstatusService;
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
@RequestMapping("/orderstatus")
public class OrderstatusController {

    @Autowired
    private OrderstatusService orderstatusService;

    //查询所有的订单状态
    @RequestMapping( "/selectorderAll")
    public String  selectareaall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Orderstatus> orderstatusPage = orderstatusService.selectPage(new Page<Orderstatus>(thispage, 2));
        request.setAttribute("orderstatusPage",orderstatusPage);

        return "orderstslist";
    }
    //删除付款方式
    @RequestMapping(value = "/delOrders")
    public String delArea (Integer orderID){
        orderstatusService.deleteById(orderID);
        return "redirect:/orderstatus/selectorderAll";
    }
    //查询到修改页面
    @RequestMapping(value = "/updOrders",method = RequestMethod.GET)
    public String updArea(Integer orderID,HttpServletRequest request){
        Orderstatus orderstatus= orderstatusService.selectById(orderID);
        request.setAttribute("orderstatus",orderstatus);
        return "orderstsUpdate" ;
    }
    //确定修改
    @RequestMapping(value = "/updOrders",method = RequestMethod.POST)
    public String updAreaOk(Orderstatus orderstatus){
        orderstatusService.updateById(orderstatus);
        return "redirect:/orderstatus/selectorderAll";
    }
    //判断付款方式是否存在
    @ResponseBody
    @RequestMapping("/isAreaEixt")
    public Orderstatus isAreaEixt(String orderName){
        System.out.println("判断是否运输工具名存在");
        Wrapper<Orderstatus> sendWrapper=new EntityWrapper<Orderstatus>();
        sendWrapper.eq("orderName",orderName);
        Orderstatus orderstatus = orderstatusService.selectOne(sendWrapper);
        if(orderstatus==null){
            orderstatus=new Orderstatus();
            return orderstatus;
        }
        return orderstatus;
    }
    //添加付款方式
    @RequestMapping(value = "/insOrders")
    public String insArea(Orderstatus orderstatus){
        orderstatusService.insert(orderstatus);
        return "redirect:/orderstatus/selectorderAll";
    }

}

