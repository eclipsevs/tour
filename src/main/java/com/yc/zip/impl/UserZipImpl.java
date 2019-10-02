package com.yc.zip.impl;

import com.yc.dao.UserMapper;
import com.yc.po.User;
import com.yc.zip.UserZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wk
 * @date 2019/9/28  10:27
 */
@Service
public class UserZipImpl implements UserZip {
    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param uname   用户名
     * @param utel    电话
     * @param upwd    密码
     * @param uidcard 身份证
     * @return
     */
    @Override
    public int add(String uname, String utel, String upwd, String uidcard) {
        System.out.println(utel + "-----" + upwd);
        if (uname == null || uidcard == null) {
            return -1;
        }
        return userMapper.add(uname, utel, upwd, uidcard);
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @param utel    手机号码
     * @param upwd    密码
     * @return
     */
    @Override
    public int login(HttpServletRequest request, HttpServletResponse response, String utel, String upwd) {
        if (utel == null || upwd == null) {
            return -1;
        }
        User user = userMapper.login(utel, upwd);
        HttpSession session = request.getSession();
        session.setAttribute("user", user.getUid());
        if (user == null) {
            System.out.println("kkkkkkkkk");
            return -1;
        } else {
            System.out.println("hhhhhhhh");
            return 1;
        }
    }
}
