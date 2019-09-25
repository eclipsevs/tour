package com.yc.zip.impl;

import com.yc.dao.OrderitemsMapper;
import com.yc.po.Orderitems;
import com.yc.zip.OrderItemZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/24  10:47
 */
@Service
public class OrderItemZipImpl implements OrderItemZip {
    @Autowired
    private OrderitemsMapper mapper;
    /**
     * 插入具体支付信息（交易号和对应的订单号）为退款做准备
     * @param list  包含交易号
     * @return
     */
    @Override
    public int insert(List<Orderitems> list) {
        return mapper.insert(list);
    }
}
