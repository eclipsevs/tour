package com.yc.zip.impl;

import com.yc.dao.UserMapper;
import com.yc.po.User;
import com.yc.zip.UserZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param uname 用户名
     * @param utel  电话
     * @param upwd  密码
     * @param uidcard 身份证
     * @return
     */
    @Override
    public int add(String uname, String utel, String upwd, String uidcard) {
        return userMapper.add(uname, utel, upwd, uidcard);
    }

    /**
     * 用户登录
     * @param utel 手机号码
     * @param upwd 密码
     * @return
     */
    @Override
    public User login(String utel, String upwd) {
        return userMapper.login(utel, upwd);
    }
}
