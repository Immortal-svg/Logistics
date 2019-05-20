package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.*;
import com.logistics.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/cardetail")
public class CardetailController {

    @Autowired
    private CardetailService cardetailService;
    @Autowired
    private TranscarService transcarService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private PaidtypeService paidtypeService;
    //点击订单明细
    @RequestMapping(value = "/selCarDetail",method = RequestMethod.GET)
    public String selCarDetail(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Cardetail> cardetailpage =cardetailService.selectpageall(thispage,2);
        request.setAttribute("cardetailpage",cardetailpage);
        return "CarDetaillist";
    }
    //客户点击订单明细
    @RequestMapping(value = "/selCarDetailOrder")
    public String  selCarDetailOrder(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,Integer customerID,HttpServletRequest request){
        Page<Cardetail> cardetailPage = cardetailService.selectpageid(thispage, 2, customerID);
        request.setAttribute("cardetailPage",cardetailPage);
        request.setAttribute("customerID",customerID);
        return "CarDetailbyCustomerIDlist";
    }
    //删除订单
    @RequestMapping(value = "/delCarDetail")
    public String  delCarDetail(String detailID){
        cardetailService.deleteById(detailID);
        return "redirect:/cardetail/selCarDetail";
    }
    //查询到修改
    @RequestMapping(value = "/updCarDetail",method = RequestMethod.GET)
    public String updCarDetail(String detailID,HttpServletRequest request){
        Page<Transcar> page=transcarService.selectTranscarAll(1,20);
        List<Customer> custs = customerService.selectList(null);
        List<Area> areas=areaService.selectList(null);
        List<Paidtype>  paidtypes=paidtypeService.selectList(null);
        request.setAttribute("areas",areas);
        request.setAttribute("transCars",page.getRecords());
        request.setAttribute("custs",custs);
        Cardetail cardetail = cardetailService.selectallid(detailID);
        request.setAttribute("carDetail",cardetail);
        request.setAttribute("paidtypes",paidtypes);
        return "CarDetailUpdate";

    }
    //确定修改
    @RequestMapping(value = "/updCarDetail",method = RequestMethod.POST)
    public String updCarDetailok(Cardetail cardetail){
        cardetailService.updateById(cardetail);
        return "redirect:/cardetail/selCarDetail";
    }
    //查询到添加页面
    @RequestMapping(value = "/insCarDetail",method = RequestMethod.GET)
    public String insCarDetail(Integer detailID,HttpServletRequest request){
        Page<Transcar> page=transcarService.selectTranscarAll(1,20);
        List<Customer> custs = customerService.selectList(null);
        List<Area> areas=areaService.selectList(null);
        List<Paidtype>  paidtypes=paidtypeService.selectList(null);
        request.setAttribute("areas",areas);
        request.setAttribute("transCars",page.getRecords());
        request.setAttribute("custs",custs);
        request.setAttribute("paidtypes",paidtypes);
        return "CarDetailAdd";
    }
    //确定添加
    @RequestMapping(value = "/insCarDetail",method = RequestMethod.POST)
    public String insCarDetailok(Cardetail cardetail){
        System.out.println(cardetail);
        cardetail.setOrderID("未发车");
        cardetailService.insertAllColumn(cardetail);
        return "redirect:/cardetail/selCarDetail";
    }
    //通过transdID查询订单
    @RequestMapping("/selectCarDeailTransID")
    public String selectCarDeailTransID(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,Integer transID,HttpServletRequest request){
        System.out.println("通过transID查询订单"+transID);
        Page<Cardetail> selecttransID = cardetailService.selecttransID(thispage, 2, transID);

        request.setAttribute("selecttransID",selecttransID);
        request.setAttribute("transID",transID);
        return "CarDetailbyTransIDlist";
    }
    //到多条件查询订单页面   selCarDetailOrderall
    @RequestMapping(value = "/selCarDetailOrderall",method = RequestMethod.GET)
    public String selCarDetailOrderall(HttpServletRequest request){
        Page<Transcar> page=transcarService.selectTranscarAll(1,20);
        List<Customer> custs=customerService.selectList(null);
         List <Area> areas=areaService.selectList(null);
         request.setAttribute("transCars",page.getRecords());
        request.setAttribute("custs",custs);
        request.setAttribute("areas",areas);
        return "CarDetailRep";
    }
    @RequestMapping(value = "/selCarDetailOrderall",method = RequestMethod.POST)
    public String selCarDetailOrderallok(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,Cardetail cardetail,HttpServletRequest request)
    {
        System.out.println("多条件订单查询"+cardetail+"\n"+cardetail.getOrderID());
        Page<Cardetail> manyconditions = cardetailService.Manyconditions(thispage, 2, cardetail);
        request.setAttribute("manyconditions",manyconditions);
        request.getSession().setAttribute("cardetailall",cardetail);
        return "CarDetailStatuslist";
    }
    @RequestMapping(value = "/selCarDetailOrderallokpage")
    public String selCarDetailOrderallokpage(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpSession session, HttpServletRequest request)
    {
        Cardetail cardetailall = (Cardetail) session.getAttribute("cardetailall");
        System.out.println("分页多条件查询page------"+cardetailall);
        Page<Cardetail> manyconditions = cardetailService.Manyconditions(thispage, 2, cardetailall);
        request.setAttribute("manyconditions",manyconditions);

        return "CarDetailStatuslist";
    }


}

