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
     *
     * @param id    订单号
     * @param trade 交易号
     * @return
     */
    @Override
    public int insert(String id, String trade) {
        if (id == null || id.length() <= 0 || trade == null || trade.length() <= 0) {
            return -1;
        }
        List<Orderitems> list = new ArrayList<>();
        String[] strs = id.split("x");
        for (String str : strs) {
            Orderitems orderitems = new Orderitems();
            orderitems.setOid(Integer.parseInt(str));
            orderitems.setOtcid(trade);
            list.add(orderitems);
        }
        return mapper.insert(list);
    }

    /**
     * 根据订单号查询交易号
     * @param oid 订单号
     * @return
     */
    @Override
    public Orderitems findByOid(Integer oid) {
        return mapper.findByOid(oid);
    }
}
