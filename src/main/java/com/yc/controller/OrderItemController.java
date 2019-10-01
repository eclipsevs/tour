package com.yc.controller;

import com.yc.po.Orderitems;
import com.yc.zip.impl.OrderItemZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/24  10:55
 */
@Controller
@RequestMapping("/OrderItem")
public class OrderItemController {
    @Autowired
    private OrderItemZipImpl orderItemZip;

    /**
     * 插入具体支付信息（交易号和对应的订单号）为退款做准备
     * @param id  所有订单号
     * @param trade  交易号
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    private int insert(String id, String trade){
        return orderItemZip.insert(id, trade);
    }
}
