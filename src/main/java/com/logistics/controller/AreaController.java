package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.service.AreaService;
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
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    //查询所有的区域
    @RequestMapping( "/selectareaall")
    public String  selectareaall(@RequestParam(value = "thispage",defaultValue = "1") Integer thispage, HttpServletRequest request){
        Page<Area> areaPage = areaService.selectPage(new Page<Area>(thispage, 2));
        request.setAttribute("areaPage",areaPage);
        return "arealist";
    }
    //删除区域
    @RequestMapping(value = "/delArea")
    public String delArea (Integer areaID){
        areaService.deleteById(areaID);
        return "redirect:/area/selectareaall";
    }
    //查询到修改页面
    @RequestMapping(value = "/updArea",method = RequestMethod.GET)
    public String updArea(Integer areaID,HttpServletRequest request){
        Area area = areaService.selectById(areaID);
        request.setAttribute("area",area);
        return "areaUpdate" ;
    }
    //确定修改
    @RequestMapping(value = "/updArea",method = RequestMethod.POST)
    public String updAreaOk(Area area){
        areaService.updateById(area);
        return "redirect:/area/selectareaall" ;
    }
    //判断区域是否存在
    @ResponseBody
    @RequestMapping("/isAreaEixt")
    public Area isAreaEixt(String areaName){
        System.out.println("判断是否区域名存在");
        Wrapper<Area> areaWrapper=new EntityWrapper<Area>();
        areaWrapper.eq("areaName",areaName);
        Area area = areaService.selectOne(areaWrapper);
        if(area==null){
            area=new Area();
            return area;
        }
        return area;
    }
  //添加区域
    @RequestMapping(value = "/insArea")
    public String insArea(Area area){
        areaService.insert(area);
        return "redirect:/area/selectareaall";
    }

}

