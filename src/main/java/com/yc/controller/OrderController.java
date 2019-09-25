package com.yc.controller;

import com.yc.po.Order;
import com.yc.zip.impl.OrderZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  13:57
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderZipImpl orderZip;

    /**
     * 查询全部待支付订单
     * @param ostatus 状态
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Object> findAll(Integer ostatus,Integer uid){
        if (ostatus == null) {
            return null;
        }


        return orderZip.findAll(ostatus,uid);
    }


    /**
     * 更新支付后的订单状态
     * @param id 订单号
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public int updateStatus(String id){
        if (id == null || id.length() <= 0) {
            return -1;
        }
        List<Order> list = new ArrayList<>();
        //分割各个订单号
        String [] oids = id.split("x");
        //循环oids获取所有的oid(订单号)
        for (String oid : oids) {
            //创建order对象，用以保存参数
            Order order = new Order();
            order.setOid(Integer.parseInt(oid));
            list.add(order);
        }
        return orderZip.updateStatus(list);
    }


    /**
     * 根据订单号移除订单
     * @param oid
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer oid){
        if (oid == null) {
            return -1;
        }
        return orderZip.delete(oid);
    }
}
