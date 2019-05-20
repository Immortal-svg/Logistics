package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.entity.Carroad;
import com.logistics.service.AreaService;
import com.logistics.service.CarroadService;
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
@RequestMapping("/carroad")
public class CarroadController {

    @Autowired
    private CarroadService carroadService;
    @Autowired
    private AreaService areaService;


    //点击id查询
    @RequestMapping("/selectcarroadID")
    public String selectcarroadID(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request, Carroad  carroad){
        System.out.println("进来carRoadID查询"+carroad);
        Page<Carroad> carroadPage = carroadService.selectpagetrandID(thispage, 10, carroad);
        carroadPage.getRecords().size();
        List<Area> areas=areaService.selectList(null);
        request.setAttribute("areas",areas);
        request.setAttribute("carroadPage",carroadPage);
        request.setAttribute("carroad",carroad);
        return "carRoad";
    }
   //通过id删除
    @RequestMapping("/delCarRoad")
    public String delCarRoad(Integer roadID){
        carroadService.deleteById(roadID);
        return "redirect:/transcar/selectTrancarAll";
    }
    //通过id查询到修改页面
    @RequestMapping(value = "/updCarRoad",method = RequestMethod.GET)
    public String updCarRoad(Integer roadID,HttpServletRequest request){
        Carroad carroad = carroadService.selectById(roadID);
        request.setAttribute("",carroad);
        return "";
    }
    //新增途径点
    @RequestMapping("/insCarRoad")
    public String insCarRoad(Carroad carroad){
        carroadService.insert(carroad);
        return "redirect:/carroad/selectcarroadID?transID="+carroad.getTransID();
    }
}

