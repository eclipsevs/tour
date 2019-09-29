package com.yc.controller;

import com.yc.po.Hotel;
import com.yc.po.Order;
import com.yc.zip.impl.HotelBizImpl;
import com.yc.zip.impl.OrderZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private HotelBizImpl hotelBiz;


    /**
     * 查询全部待支付订单
     * @param ostatus 状态
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Object> findAll(HttpServletRequest request, Integer ostatus){
        if (ostatus == null) {
            return null;
        }
        HttpSession session = request.getSession();
        int uid = (Integer) session.getAttribute("user");
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

    /**
     * 根据酒店id和用户id插入订单
     * @param id 酒店id
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(HttpServletRequest request, Integer id){
        if (id == null ) {
            System.out.println("参数为空");
            return -1;
        }
        HttpSession session = request.getSession();
        int uid = (Integer) session.getAttribute("user");
        //查询对应酒店的单价数据
        Hotel hotel = hotelBiz.findById(id);
        Double oprice = hotel.getPrice();
        //调用插入方法插入数据
        return orderZip.add(id, uid, oprice);
    }
}
