package com.logistics.Intercpetor;

import com.logistics.entity.Accmodule;
import com.logistics.entity.Users;
import com.logistics.service.AccmoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author q
 * @create 2019- 05- 13 17:10
 */
public class quanxianInterceptor implements HandlerInterceptor {

    @Autowired
    private AccmoduleService accmoduleService;

    // controller执行后且视图返回后调用此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session=request.getSession();
        String url=request.getRequestURI();
        System.out.println("请求路径--------"+request.getRequestURI());
        if (url.contains("login.action")||url.contains(".css")||url.contains("images")||url.contains("js")||url.contains("laydate")||url.contains("layui")
        ||url.contains("users/exit")||url.contains("users/getremain.aspx")||url.contains("isexit")||url.contains("isAreaEixt")) {
            return true;
        }
        Users user=(Users) session.getAttribute("users");
        if(user==null){
          return false;
         }
        List<Accmodule> exit=accmoduleService.selectisexitmodule(user.getId());
        String[] split = url.split("/");
        String u=split[2]+"/"+split[3];
        System.out.println("---连接的路劲"+u);
        System.out.println("contorller执行后调用");
        boolean fang=false;
        for (Accmodule a: exit) {
           /* System.out.println(a.getModule().getMoethod()+a.getModule().getModuleName());*/
           if(a.getModule().getMoethod().equals(u)){
               fang=true;
           }
        }
        System.out.println("是否放行"+fang);
        if(fang==false){
            request.setAttribute("noAccnoAcc","没有权限");
            request.getRequestDispatcher("/right.jsp").forward(request, response);
            return  false;
        }
        return true;
    }
    // controller执行后但未返回视图前调用此方法
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
       /* System.out.println(" controller执行后但未返回视图前调用此方法");*/
    }


    // Controller执行前调用此方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    /*    System.out.println(" Controller执行前调用此方法");*/
    }
}
