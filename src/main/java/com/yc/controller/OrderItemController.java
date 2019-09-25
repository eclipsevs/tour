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
        System.out.println(id+"---"+trade);
        if (id == null || id.length()<=0 || trade == null || trade.length()<=0 ) {
            return -1;
        }
        List<Orderitems> list = new ArrayList<>();
        String [] strs = id.split("x");
        for (String str : strs) {
            Orderitems orderitems = new Orderitems();
            System.out.println(str);
            orderitems.setOid(Integer.parseInt(str));
            orderitems.setOtcid(trade);
            list.add(orderitems);
        }
        return orderItemZip.insert(list);
    }
}
