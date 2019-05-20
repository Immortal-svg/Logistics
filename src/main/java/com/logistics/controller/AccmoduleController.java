package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.logistics.entity.Accmodule;
import com.logistics.entity.Module;
import com.logistics.entity.Users;
import com.logistics.service.AccmoduleService;
import com.logistics.service.ModuleService;
import com.logistics.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
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
@RequestMapping("/accmodule")
public class AccmoduleController {

    @Autowired
    private AccmoduleService accmoduleService;
   @Autowired
    private UsersService usersService;
   @Autowired
   private ModuleService moduleService;

   //通过用户id查询权限
    @RequestMapping(value = "/selAccModule",method = RequestMethod.GET)
    public String selAccModule(Integer userID, HttpServletRequest request){
       List<Module> Modules=moduleService.selectList(null);
       List<Users> userList=usersService.selectList(null);
       List<Accmodule> usermod=accmoduleService.selAccModule(userID);
       request.setAttribute("userList",userList);
       request.setAttribute("Modules",Modules);
       request.setAttribute("usermod",usermod);
        request.setAttribute("userID",userID);
       return "accModuleList";
    }
    //通过用户id查询权限
    @RequestMapping(value = "/selAccModule",method = RequestMethod.POST)
    public String selAccModuleID(Integer userID, HttpServletRequest request){
        List<Module> Modules=moduleService.selectList(null);
        List<Users> userList=usersService.selectList(null);
        List<Accmodule> usermod=accmoduleService.selAccModule(userID);
        request.setAttribute("userList",userList);
        request.setAttribute("Modules",Modules);
        request.setAttribute("usermod",usermod);
        request.setAttribute("userID",userID);

        return "accModuleList";
    }
    //授予权限
    @RequestMapping("/insAccModule")
     public String insAccModule(@RequestParam Integer userID, @RequestParam Integer [] moduleID , HttpServletRequest request ){
        System.out.println("授予权限进入");
        Wrapper<Accmodule> accmoduleWrapper=new EntityWrapper<Accmodule>();
        accmoduleWrapper.eq("userID", userID);
        List<Accmodule> list = accmoduleService.selectList(accmoduleWrapper);
        List<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            for(int k=0;k<moduleID.length;k++){
                if(list.get(i).getModuleID()==moduleID[k]){
                    a.add(moduleID[k]);
                }
            }
        }
        System.out.println("之前-----"+a);
        List<Integer> moudel= Arrays.asList(moduleID);
        List<Integer> demo=new ArrayList<Integer>();
        demo.addAll(moudel);
        demo.removeAll(a);
        System.out.println("之后-----"+demo);
        Integer id[]=new Integer[demo.size()];
        demo.toArray(id);
        for (int i:id) {
            System.out.println("id++++++++"+i);
        }
        if(id.length!=0) {
            accmoduleService.insAccModule(userID, id);
        }
        List<Module> Modules=moduleService.selectList(null);
        List<Users> userList=usersService.selectList(null);
        List<Accmodule> usermod=accmoduleService.selAccModule(userID);
        request.setAttribute("userList",userList);
        request.setAttribute("Modules",Modules);
        request.setAttribute("usermod",usermod);
        request.setAttribute("userID",userID);
        return "accModuleList";
    }
    //删除权限
    @RequestMapping("/delAccModule")
   public String delAccModule(Integer userID,Integer [] accid ,HttpServletRequest request ){
        System.out.println("删除的长度------"+accid.length);
       if(accid.length!=0) {
         accmoduleService.delAccModule(userID, accid);
       }
        List<Module> Modules=moduleService.selectList(null);
        List<Users> userList=usersService.selectList(null);
        List<Accmodule> usermod=accmoduleService.selAccModule(userID);
        request.setAttribute("userList",userList);
        request.setAttribute("Modules",Modules);
        request.setAttribute("usermod",usermod);
        request.setAttribute("userID",userID);
        return "accModuleList";
    }
}

