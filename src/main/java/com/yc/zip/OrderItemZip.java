package com.yc.zip;

import com.yc.po.Orderitems;

import java.util.List;

/**
 * @author wk
 * @date 2019/9/24  10:41
 */
public interface OrderItemZip {
    /**
     * 插入具体支付信息（交易号和对应的订单号）为退款做准备
     *
     * @param id    订单号
     * @param trade 交易号
     * @return
     */
    public int insert(String id, String trade);

    /**
     * 根据订单号查询交易号
     * @param oid 订单号
     * @return
     */
    Orderitems findByOid(Integer oid);
}
