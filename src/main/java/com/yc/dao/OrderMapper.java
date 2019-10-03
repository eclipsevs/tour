package com.yc.dao;

import com.yc.po.Hotel;
import com.yc.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  13:57
 */
public interface OrderMapper {

    /**
     * 根据酒店id和用户id加入购物车
     *
     * @param id
     * @param uid
     * @return
     */
    public int add(@Param("id") Integer id, @Param("uid") Integer uid,
                   @Param("oprice") Double oprice);

    /**
     * 查看全部待付款订单
     *
     * @param ostatus 状态码
     * @param uid     用户id
     * @return
     */
    public List<Order> findAll(@Param("ostatus") Integer ostatus, @Param("uid") Integer uid);

    /**
     * 修改支付完成的订单状态
     *
     * @param list    包含要修改的订单号和用户编号
     * @param ostatus 状态码
     * @return
     */
    public int updateStatus(@Param("list") List<Order> list, @Param("ostatus") Integer ostatus);

    /**
     * 根据id删除订单
     *
     * @param oid 订单号
     * @return
     */
    public int delete(Integer oid);

    /**
     * 根据商品号，用户编号和状态号查询购物车中是否有未支付的该商品号的商品，
     * 来判断是插入新数据还是更新数据的数量
     *
     * @param ocid    商品号
     * @param uid     用户编号
     * @param ostatus 状态号
     * @return
     */
    Hotel findByIdAndUid(@Param("ocid") Integer ocid, @Param("uid") Integer uid,
                         @Param("ostatus") Integer ostatus);

    /**
     * 更新订单的商品数量
     *
     * @param id  订单号
     * @param num 修改数量
     * @return
     */
    int updateNum(@Param("id") Integer id, @Param("num") Integer num);
}