package com.yc.controller;

import com.yc.zip.impl.OrderZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
     *
     * @param ostatus 状态
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Object> findAll(HttpServletRequest request, Integer ostatus) {
        return orderZip.findAll(request, ostatus);
    }


    /**
     * 更新支付后的订单状态
     *
     * @param id 订单号
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public int updateStatus(String id) {
        return orderZip.updateStatus(id);
    }


    /**
     * 根据订单号移除订单
     *
     * @param oid
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer oid) {
        return orderZip.delete(oid);
    }

    /**
     * 根据酒店id和用户id插入订单
     *
     * @param id 酒店id
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(HttpServletRequest request, Integer id) {
        //调用插入方法插入数据
        return orderZip.add(request, id);
    }
}
