package com.logistics.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.entity.Car;
import com.logistics.entity.Customer;
import com.logistics.service.AreaService;
import com.logistics.service.CarService;
import com.logistics.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  汽车控制器
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AreaService areaService;

    //点击到添加汽车页面
    @RequestMapping(value = "/insCar",method =RequestMethod.GET)
    public String   isadd(HttpServletRequest request){
        List<Customer> custs = customerService.selectList(null);
        List<Area>    areas=areaService.selectList(null);
        request.setAttribute("custs",custs);
        request.setAttribute("areas",areas);
        return "carAdd";
    }
    //确定添加汽车
    @RequestMapping(value = "/insCar",method = RequestMethod.POST)
    public String   add(Car car, HttpServletRequest request){
        carService.insert(car);
        return "redirect:/car/selectCarall";
    }
    //查询所有的汽车
        @RequestMapping("/selectCarall")
    public String  selectCarall(@RequestParam(value = "thispage",defaultValue = "1")Integer thispage,HttpServletRequest request){
        Page<Car> carPage= carService.selectpageall(thispage,2);
        request.setAttribute("carPage",carPage);
        return  "carlist";
    }
    //根据id删除
    @RequestMapping("/deleCar")
    public String deleCar(Integer carID){
        carService.deleteById(carID);
        return "redirect:/car/selectCarall";
    }
    //根据id查询到修改页面
    @RequestMapping("/selectCarByid")
    public String selectCarByid(Integer carID,HttpServletRequest request){
        Car car = carService.selectById(carID);
        List<Customer>  custs=customerService.selectList(null);
        List<Area> areas=areaService.selectList(null);
        request.setAttribute("custs",custs);
        request.setAttribute("areas",areas);
        request.setAttribute("car",car);
        return "carUpdate";
    }
    //根据id修改
    @RequestMapping("/updateCar")
    public String updateCar(Car  car){
        carService.updateById(car);
        return "redirect:/car/selectCarall";
    }
}

