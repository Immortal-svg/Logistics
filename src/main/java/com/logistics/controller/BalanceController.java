package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Balance;
import com.logistics.entity.Customer;
import com.logistics.entity.Customertype;
import com.logistics.service.BalanceService;
import com.logistics.service.CustomerService;
import com.logistics.service.CustomertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;
    @Autowired
    private CustomertypeService customertypeService;
    @Autowired
    private CustomerService customerService;

    //添加收付款
    @RequestMapping("/insBalance")
    public String insBalance(Balance balance){
        System.out.println("进来-----------------");

        balanceService.insert(balance);
        return  "forward:/customer/customerall";
    }
    //点击收付款明细
    @RequestMapping(value ="selBalance" )
    public String selBalance(Integer customerID, HttpServletRequest request,@RequestParam(value = "thispage",defaultValue = "1") Integer thispage){

        System.out.println("进入点击收付款明细"+customerID);
        Balance balance=new Balance();
        balance.setCustomerID(customerID);
        Page<Balance> balancePage = balanceService.page(thispage, 2, balance);
        request.setAttribute("balancePage",balancePage);
        request.setAttribute("customerID",customerID);
        return "balancelist";
    }
    //点击作废
    @RequestMapping(value ="/delBalance" )
    public String  delBalance(Balance balance,Integer cusid){
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Balance balance1 = balanceService.selectById(balance.getBalanceID());
        if(balance1.getIsvalID().equals("作废")){
            balance.setIsvalID("有效");
        }
        if(balance1.getIsvalID().equals("有效")){
            balance.setIsvalID("作废");
        }
        balance.setOprTime(new Date());
        balanceService.updateById(balance);
        return "forward:/balance/selBalance?customerID="+cusid;
    }
    //点击收付款管理
    @RequestMapping(value = "/selBalanceall",method = RequestMethod.GET)
    public String selBalanceall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,HttpServletRequest request){
        List<Customertype> customertypes = customertypeService.selectList(null);
        Customer customer= (Customer)request.getSession().getAttribute("c");
        if(customer ==null){
            customer=new Customer();
        }
        Page<Customer> selectfinance = customerService.selectall(thispage, 2, customer);
        request.setAttribute("selectfinance",selectfinance);
        request.setAttribute("custtypes",customertypes);
        return  "customerRep";
    }
    //财务收付款条件查询
    @RequestMapping(value = "/selBalanceall",method = RequestMethod.POST)
    public String selBalanceallok(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,HttpServletRequest request,Customer customer){
        List<Customertype> customertypes = customertypeService.selectList(null);
        Page<Customer> selectfinance = customerService.selectall(thispage, 2, customer);
        request.setAttribute("selectfinance",selectfinance);
        request.setAttribute("custtypes",customertypes);
        request.getSession().setAttribute("c",customer);
        return  "customerRep";
    }
    //点击客户往来明细
    @RequestMapping(value ="/selBalanceCustDetail" ,method = RequestMethod.GET)
    public String selBalanceCustDetail(@RequestParam(value = "thispage",defaultValue = "1")Integer thispage,HttpServletRequest request,HttpSession session
    ){
        Balance balance=(Balance) session.getAttribute("balance");
        String paidTime1=(String) session.getAttribute("paidTime1");
        String paidTime2=  (String)session.getAttribute("paidTime2");
        String customerName  =(String) session.getAttribute("customerName");
        if(balance==null){
            balance=new Balance();
        }
        Page<Balance> selectfinance = balanceService.selectfinance(thispage, 2,
                balance,customerName,paidTime1,paidTime2);
        request.setAttribute("selectfinance",selectfinance);
        return "BalanceRep";
    }
    //条件查询
    @RequestMapping(value ="/selBalanceCustDetail" ,method = RequestMethod.POST)
    public String selBalanceCustDetailok(@RequestParam(value = "thispage",defaultValue = "1")Integer thispage, HttpServletRequest request,
          Balance balance, String paidTime1, String paidTime2, String customerName, HttpSession session){
        Page<Balance> selectfinance = balanceService.selectfinance(thispage, 2,
                balance,customerName,paidTime1,paidTime2);
        request.setAttribute("selectfinance",selectfinance);
        session.setAttribute("balance",balance);
        session.setAttribute("paidTime1",paidTime1);
        session.setAttribute("paidTime2",paidTime2);
        session.setAttribute("customerName",customerName);
        return "BalanceRep";
    }
    //客户账目往来统计
    @RequestMapping(value = "/selBalanceCustStatis",method = RequestMethod.GET)
    public String selBalanceCustStatis(@RequestParam(value = "thispage",defaultValue = "1")Integer thispage,HttpSession session,HttpServletRequest request){
        String paidTime=(String ) session.getAttribute("paidTime");
        String oprTime =(String )session.getAttribute("oprTime");
        Page<Balance> selectcountall = balanceService.selectcountall(thispage, 2, paidTime, oprTime);
        request.setAttribute("selectcountall",selectcountall);
        return "BalanceRep2";
    }
    //客户账目往来统计条件查询
    @RequestMapping(value = "/selBalanceCustStatis",method = RequestMethod.POST)
    public String selBalanceCustStatisok(@RequestParam(value = "thispage",defaultValue = "1")Integer thispage,HttpSession session,
                                         HttpServletRequest request,String paidTime,String oprTime){
        Page<Balance> selectcountall = balanceService.selectcountall(thispage, 2, paidTime, oprTime);
        session.setAttribute("paidTime",paidTime);
        session.setAttribute("oprTime",oprTime);
        request.setAttribute("selectcountall",selectcountall);

        return "BalanceRep2";
    }
  }

