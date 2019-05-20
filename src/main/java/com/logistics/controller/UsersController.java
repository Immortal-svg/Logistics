package com.logistics.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Area;
import com.logistics.entity.Users;
import com.logistics.service.AreaService;
import com.logistics.service.UsersService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 *     用户控制层
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AreaService  areaService;
   //登录功能
    @RequestMapping("/login.action")
    public String login(Users users, HttpSession session, HttpServletRequest request, String yzm, String remember, HttpServletResponse response){
         String rand = (String) session.getAttribute("rand");
         rand=rand.toLowerCase();
         yzm=yzm.toLowerCase();
         System.out.println("-----------"+rand+"\n"+yzm);
         Wrapper<Users> usersWrapper=new EntityWrapper<Users>();
         usersWrapper.eq("userName",users.getUserName());
         usersWrapper.eq("password",users.getPassword());
         users = usersService.selectOne(usersWrapper);
         System.out.println("-------------------------"+users);
        System.out.println("是否记住密码"+remember);
        if(users!=null) {
            if (remember != null) {
                if (remember.equals("1")) {//记住密码
                    System.out.println("记住密码");
                    Cookie userName_c = new Cookie("userName", users.getUserName());
                    Cookie password_c = new Cookie("password", users.getPassword());
                    userName_c.setPath("/");
                    password_c.setPath("/");
                    userName_c.setMaxAge(60 * 60 * 24 * 7);
                    password_c.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(userName_c);
                    response.addCookie(password_c);
                }
            } else {
                System.out.println("清除");
                Cookie cookies[] = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userName")) {

                        cookie.setPath("/");
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                    if (cookie.getName().equals("password")) {
                        cookie.setPath("/");
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }
        if(users == null){
            request.setAttribute("islogin","failed");//用户或密码密码有误
            return "index";
        }else if(!(yzm.equals(rand))){
            request.setAttribute("islogin","yzm");//验证码不匹配
            return "index";
        }else if(users.getStaus()== 0){
            request.setAttribute("islogin","dis");//状态
            return "index";
        }else {
            session.setAttribute("users",users);
            return "main";
        }
    }
    //用户退出
    @RequestMapping("/exit")
    public String  exit(HttpSession session){
          session.removeAttribute("users");
          return "index";
    }
    //点击到添加用户页面
    @RequestMapping("/isadd")
    public String insUser(HttpServletRequest request){
        List<Area> areas = areaService.selectList(null);
        request.setAttribute("areas",areas);//
        return "userAdd";
    }
    //新增用户
    @RequestMapping("/addok")
    public String  insUser1(Users users){
        System.out.println(users);
        usersService.insert(users);
        return "redirect:/users/userAll?thispage=1";
    }
    //判断添加的用户名是否存在
    @ResponseBody
    @RequestMapping("/isexit")
    public Users  isexit(String name){
        Wrapper <Users> usersWrapper=new EntityWrapper<Users>();
        usersWrapper.eq("userName",name);
        Users users = usersService.selectOne(usersWrapper);
        if(users==null){
            users=new Users();
            return users;
        }
        return users;
    }
    //查询所有用户
    @RequestMapping("/userAll")
    public String  userAll(Integer thispage,HttpServletRequest request){
        System.out.println("进来了---");
        Page<Users> userspage = usersService.selectPage(new Page<Users>(thispage, 2));
        request.setAttribute("userspage",userspage);

        System.out.println("==================");
        System.out.println("总条数"+userspage.getTotal());
        System.out.println("每条记录显示条数"+userspage.getSize());
        System.out.println("当前页码："+userspage.getCurrent());
        System.out.println("总页数："+userspage.getPages());
        System.out.println("当前页数的记录数"+userspage.getRecords());
        System.out.println("上一页"+userspage.hasPrevious());
        System.out.println("下一页"+userspage.hasNext());
        System.out.println("==================");
        return "userlist";
    }
    //删除用户
    @RequestMapping("/delete")
    public String delUser(Integer id){
        usersService.deleteById(id);
        return "redirect:/users/userAll?thispage=1";
    }
    //修改状态
    @RequestMapping("/staus")
    public String updUserStatus(Integer id,Integer staus){
         Users users=new Users();
         users.setId(id);
          if(staus==1){
              users.setStaus(0);
          }else{
              users.setStaus(1);
          }

        usersService.updateById(users);
        return "redirect:/users/userAll?thispage=1";
    }
   //点击到修改页面
    @RequestMapping("/isupdate")
    public String updateUser(Integer id,HttpServletRequest request){
        List<Area> areas = areaService.selectList(null);
        request.setAttribute("areas",areas);
        Users users=usersService.selectById(id);
        request.setAttribute("user",users);
        return "userUpdate";
    }
    //确定修改
    @RequestMapping("/updateUser")
    public String updateUser1(Users users,HttpSession session){
        usersService.updateById(users);
        return "redirect:/users/userAll?thispage=1";
    }
    //点击到修改页面密码
    @RequestMapping("/uppassword")
    public String updatepassword(Integer id,HttpSession session,HttpServletRequest request){
        Users users= usersService.selectById(id);
        request.setAttribute("users",users);
        return "modifypwd";
    }
    //确定修改密码
    @RequestMapping("/uppass")
    public String up(Users user,HttpSession session){
        usersService.updateById(user);
        user= usersService.selectById(user.getId());
        session.setAttribute("users",user);
        return "redirect:/users/uppassword";
    }
}

