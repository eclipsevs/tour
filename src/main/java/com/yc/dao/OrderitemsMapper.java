package com.yc.dao;

import com.yc.po.Orderitems;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wk
 */
public interface OrderitemsMapper {
    /**
     * 插入具体支付信息（交易号和对应的订单号）为退款做准备
     * @param list 包含交易号和订单号
     * @return
     */
    public int insert(List<Orderitems> list);
}