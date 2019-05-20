package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.entity.Customer;
import com.logistics.entity.Customertype;
import com.logistics.entity.Paidtype;
import com.logistics.service.AreaService;
import com.logistics.service.CustomerService;
import com.logistics.service.CustomertypeService;
import com.logistics.service.PaidtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaidtypeService paidtypeService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private CustomertypeService customertypeService;

  //到添加客户页面
   @RequestMapping(value = "/insCust",method = RequestMethod.GET)
    public String insCust(HttpServletRequest request){
     List<Paidtype> paidtypes=paidtypeService.selectList(null);
     List<Area>  areas=areaService.selectList(null);
     List<Customertype>  custtypes=customertypeService.selectList(null);
      request.setAttribute("paidtypes",paidtypes);
       request.setAttribute("areas",areas);
       request.setAttribute("custtypes",custtypes);
       return "customerAdd";
   }
   //添加
   @RequestMapping(value = "/insCust",method = RequestMethod.POST)
   public String insCustok(Customer customer){
        customerService.insert(customer);
       return "redirect:/customer/customerall";
   }
   //客户资料
    @RequestMapping(value = "/customerall")
    public String all(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Customer> custspage = customerService.selectModelPage(thispage,2);
       /* System.out.println("==================");
        System.out.println("总条数"+custspage.getTotal());
        System.out.println("每条记录显示条数"+custspage.getSize());
        System.out.println("当前页码："+custspage.getCurrent());
        System.out.println("总页数："+custspage.getPages());
        System.out.println("当前页数的记录数"+custspage.getRecords());
        System.out.println("上一页"+custspage.hasPrevious());
        System.out.println("下一页"+custspage.hasNext());
        System.out.println("==================");
        for (Customer c:custspage.getRecords()) {
            System.out.println(c.getArea().getAreaName());
        }*/
        request.setAttribute("custspage",custspage);
        return "customerlist" ;
   }
    //删除客户
    @RequestMapping("/delCust")
    public String  delCust(Integer id){
       customerService.deleteById(id);
       return "redirect:/customer/customerall";
    }
    //查询到修改页面
    @RequestMapping(value = "/updCust",method = RequestMethod.GET)
    public String updCust(Customer cust,HttpServletRequest  request){
        cust = customerService.selectById(cust.getCustomerID());
        List<Paidtype> paidtypes=paidtypeService.selectList(null);
        List<Area>  areas=areaService.selectList(null);
        List<Customertype>  custtypes=customertypeService.selectList(null);
        request.setAttribute("paidtypes",paidtypes);
        request.setAttribute("areas",areas);
        request.setAttribute("custtypes",custtypes);
        request.setAttribute("cust",cust);
        return "customerUpdate";
    }
   //确定修改
    @RequestMapping(value = "/updCust",method = RequestMethod.POST)
    public String   updCustok(Customer customer){
       customerService.updateById(customer);
       return "redirect:/customer/customerall";
    }
    //点击收/付款
    @RequestMapping(value = "/selCustBalance")
    public String selCustBalance(Integer customerID,HttpServletRequest request){
        Customer customer = customerService.selectById(customerID);
        request.setAttribute("cust",customer);
        return "balanceAdd";
   }



}

