package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.entity.Car;
import com.logistics.entity.Sendtype;
import com.logistics.entity.Transcar;
import com.logistics.service.AreaService;
import com.logistics.service.CarService;
import com.logistics.service.SendtypeService;
import com.logistics.service.TranscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/transcar")
public class TranscarController {

    @Autowired
    private TranscarService transcarService;
    @Autowired
    private CarService carService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private SendtypeService sendtypeService;
    //查询车辆信息
    @RequestMapping("/selectTrancarAll")
    public String selectTrancarall(@RequestParam(value = "thispage", defaultValue = "1") Integer thispage, HttpServletRequest request) {
        Page<Transcar> transcarPage = transcarService.selectTranscarAll(thispage, 2);
        request.setAttribute("transcarPage", transcarPage);
        return "transCarlist";
    }
    //判断是否已发车
    @ResponseBody
    @RequestMapping("/iscarStatus")
    public  Transcar iscarStatus(Integer transID){
        System.out.println("进来判断是否出车");
        Transcar transcar = transcarService.selectById(transID);
        return transcar;
    }
    //根据id删除
    @RequestMapping("/delTrans")
    public String deleteTrancarId(Integer transID) {
        System.out.println("进入删除");
        transcarService.deleteById(transID);
        return "redirect:/transcar/selectTrancarAll";
    }

    //根据id查询
    @RequestMapping(value = "/updCar", method = RequestMethod.GET)
    public String updCar(Integer ransID, HttpServletRequest request) {
        List<Car> cars = carService.selectList(null);
        List<Area> areas = areaService.selectList(null);
        List<Sendtype> sendtypes = sendtypeService.selectList(null);
        Transcar transCar = transcarService.selectById(ransID);
        request.setAttribute("cars", cars);
        request.setAttribute("areas", areas);
        request.setAttribute("sendtypes", sendtypes);
        request.setAttribute("transCar", transCar);
        System.out.println(transCar);
        return "transCarUpdate";
    }

    //根据id修改
    @RequestMapping(value = "/updCar", method = RequestMethod.POST)
    public String updCarok(Transcar transcar) {
        System.out.println("进入更新");
         transcarService.updateById(transcar);
         return "redirect:/transcar/selectTrancarAll";
    }
    //查询到添加页面
    @RequestMapping(value = "/insTrans",method = RequestMethod.GET)
    public String insTrans(HttpServletRequest request){
        List<Car> cars = carService.selectList(null);
        List<Area> areas = areaService.selectList(null);
        List<Sendtype> sendtypes = sendtypeService.selectList(null);
        request.setAttribute("cars", cars);
        request.setAttribute("areas", areas);
        request.setAttribute("sendtypes", sendtypes);
        return "transCarAdd";
    }
    //添加成功
    @RequestMapping(value = "/insTrans",method = RequestMethod.POST)
    public String insTransok(Transcar transcar,HttpServletRequest request){
        System.out.println(transcar);
        transcar.setCarStatus("未发车");
        transcar.setGcount(0);
       transcarService.insert(transcar);
        return "redirect:/transcar/selectTrancarAll";
    }
    //根据未发车状态查询
    @RequestMapping(value = "/selTransNotStrat")
    public String selTransNotStrat(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,String carStatus,HttpServletRequest request){
        carStatus="未发车";
        Page<Transcar> pagecarStatus = transcarService.selectcarStatus(thispage, 2, carStatus);
        request.setAttribute("pagecarStatus",pagecarStatus);
        return "transCarStartlist";
    }
   //修改车未发车状态
    @RequestMapping(value ="/updSetTrans" )
    public String  updSetTrans(Integer transID){
        Transcar transcar = transcarService.selectById(transID);
        if(transcar.getCarStatus().equals("未发车")){
            transcar.setCarStatus("已发车");
            transcarService.updateById(transcar);
            return "redirect:/transcar/selTransNotStrat";
        }
        if(transcar.getCarStatus().equals("已发车")){
            transcar.setCarStatus("已到站");
            transcarService.updateById(transcar);
            return "redirect:/transcar/selTransStart";
        }
       return null;
    };
    //查询已发车
    @RequestMapping(value ="selTransStart")
    public String selTransStart(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,String carStatus,HttpServletRequest request){
        carStatus="已发车";
        Page<Transcar> yifache = transcarService.selectcarStatus(thispage, 2, carStatus);
        request.setAttribute("yifache",yifache);
        return "transCarFinishlist" ;
    }
    //查询已到站
    @RequestMapping(value ="selArriveTrans")
    public String selArriveTrans(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage,String carStatus,HttpServletRequest request){
        carStatus="已到站";
        Page<Transcar> daozhan = transcarService.selectcarStatus(thispage, 2, carStatus);
        System.out.println(daozhan.getRecords());
        for (Transcar t :daozhan.getRecords()) {
            System.out.println(t);
        }
        request.setAttribute("daozhan",daozhan);
        return "transCarOverlist" ;
    }


}