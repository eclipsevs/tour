package com.yc.controller;

import com.yc.po.User;
import com.yc.zip.impl.UserZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        System.out.println(utel+"-----"+upwd);
        if (uname == null || uidcard == null) {
            return -1;
        }
        return userZip.add(uname, utel, upwd, uidcard);
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login(HttpServletRequest request,String utel, String upwd){
        if (utel == null || upwd == null ) {
            return -1;
        }
        User user = userZip.login(utel, upwd);
        HttpSession session = request.getSession();
        session.setAttribute("user",user.getUid());
        if (user==null){
            return  -1;
        }else {
            return 1;
        }

    }
}
