package com.yc.controller;

import com.yc.zip.impl.UserZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wk
 * @date 2019/9/28  10:44
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 自动装配UserZipImpl对象
     */
    @Autowired
    private UserZipImpl userZip;

    /**
     * 添加用户
     * @param uname 姓名
     * @param utel 号码
     * @param upwd 密码
     * @param uidcard  身份证号码
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(String uname, String utel, String upwd, String uidcard){
        return userZip.add(uname, utel, upwd, uidcard);
    }

    /**
     * 用户登录
     * @param request
     * @param utel  手机号码
     * @param upwd  密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public int login(HttpServletRequest request, HttpServletResponse response, String utel, String upwd)  {
        return userZip.login(request,response,utel, upwd);
    }
}
