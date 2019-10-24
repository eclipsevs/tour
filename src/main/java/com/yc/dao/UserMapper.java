package com.yc.dao;

import com.yc.po.User;
import org.apache.ibatis.annotations.Param;


/**
 * @author Administrator
 */
public interface UserMapper {
    /**
     * 添加用户
     * @param uname 用户名
     * @param utel  电话
     * @param upwd  密码
     * @param uidcard 身份证
     * @return
     */
     int add(@Param("uname") String uname, @Param("utel") String utel,
                   @Param("upwd") String upwd, @Param("uidcard") String uidcard);

    /**
     * 用户登录
     * @param utel 手机号码
     * @param upwd 密码
     * @return
     */
     User login(@Param("utel") String utel, @Param("upwd")String upwd);

    /**
     * 根据用户id来查询用户信息
     * @param uid
     * @return
     */
     User findById(int uid);
}