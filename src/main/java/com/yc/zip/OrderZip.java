package com.yc.zip;

import com.yc.po.Hotel;
import com.yc.po.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  13:58
 */
public interface OrderZip {

    /**
     * 查看全部待付款订单
     *
     * @param request
     * @param ostatus 状态码
     * @return
     */
    public List<Order> findAll(HttpServletRequest request, Integer ostatus);

    /**
     * 修改支付完成的订单状态
     *
     * @param id 包含要修改的订单号和用户编号
     * @param ostatus 状态码
     * @return
     */
    public int updateStatus(String id,Integer ostatus );

    /**
     * 根据id删除订单
     *
     * @param oid 订单号
     * @return
     */
    public int delete(Integer oid);

    /**
     * 根据酒店id和用户id插入订单
     *
     * @param request
     * @param id     酒店id
     * @return
     */
    public int add(HttpServletRequest request, Integer id);

    /**
     * 根据商品号，用户编号和状态号查询购物车中是否有未支付的该商品号的商品，
     * 来判断是插入新数据还是更新数据的数量
     *
     * @param ocid 商品号
     * @param uid 用户编号
     * @param ostatus 状态号
     * @return
     */
    Hotel findByIdAndUid( Integer ocid, Integer uid, Integer ostatus );

    /**
     * 更新订单的商品数量
     *
     * @param id 订单号
     * @param num 修改数量
     * @return
     */
    int updateNum(Integer id, Integer num);
}
