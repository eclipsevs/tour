package com.yc.zip;

import com.yc.po.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wk
 * @date 2019/9/28  10:26
 */
public interface UserZip {
    /**
     * 添加用户
     *
     * @param uname   用户名
     * @param utel    电话
     * @param upwd    密码
     * @param uidcard 身份证
     * @return
     */
    int add(String uname, String utel, String upwd, String uidcard);

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @param utel    手机号码
     * @param upwd    密码
     * @return
     */
    int login(HttpServletRequest request, HttpServletResponse response, String utel, String upwd) throws ServletException, IOException;
}
