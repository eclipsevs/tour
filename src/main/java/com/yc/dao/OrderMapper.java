package com.yc.dao;

import com.yc.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author wk
 * @date 2019/9/23  13:57
 */
public interface OrderMapper {

    /**
     * 查看全部待付款订单
     * @param ostatus 状态码
     * @param uid  用户id
     * @return
     */
    public List<Object> findAll(@Param("ostatus") Integer ostatus, @Param("uid") Integer uid);

    /**
     * 修改支付完成的订单状态
     * @param list 包含要修改的订单号和用户编号
     * @return
     */
    public int updateStatus(List<Order> list);

    /**
     * 根据id删除订单
     * @param oid 订单号
     * @return
     */
    public int delete(Integer oid);
}