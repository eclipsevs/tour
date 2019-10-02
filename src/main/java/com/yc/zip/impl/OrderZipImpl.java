package com.yc.zip.impl;

import com.yc.dao.OrderMapper;
import com.yc.po.Hotel;
import com.yc.po.Order;
import com.yc.zip.OrderZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  14:39
 */
@Service
public class OrderZipImpl implements OrderZip {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private HotelBizImpl hotelBiz;

    /**
     * 查询登录用户所有未支付订单
     *
     * @param request
     * @param ostatus 状态码
     * @return
     */
    @Override
    public List<Order> findAll(HttpServletRequest request, Integer ostatus) {
        if (ostatus == null) {
            return null;
        }
        //获取当前用户id
        HttpSession session = request.getSession();
        int uid = (Integer) session.getAttribute("user");
        return orderMapper.findAll(ostatus, uid);
    }

    /**
     * 支付后修改订单状态
     * @param id 包含要修改的订单号和用户编号
     * @param ostatus 状态码
     * @return
     */
    @Override
    public int updateStatus(String id,Integer ostatus) {
        if (id == null || id.length() <= 0) {
            return -1;
        }
        List<Order> list = new ArrayList<>();
        //分割各个订单号
        String[] oids = id.split("x");
        //循环oids获取所有的oid(订单号)
        for (String oid : oids) {
            //创建order对象，用以保存参数
            Order order = new Order();
            order.setOid(Integer.parseInt(oid));
            list.add(order);
        }
        return orderMapper.updateStatus(list,ostatus);
    }

    /**
     * 删除订单
     *
     * @param oid 订单号
     * @return
     */
    @Override
    public int delete(Integer oid) {
        if (oid == null) {
            return -1;
        }
        return orderMapper.delete(oid);
    }

    /**
     * 插入订单
     *
     * @param id     酒店id
     * @return
     */
    @Override
    public int add(HttpServletRequest request, Integer id) {
        if (id == null ) {
            System.out.println("参数为空");
            return -1;
        }
        //获取当前登录用户id
        HttpSession session = request.getSession();
        int uid = (Integer) session.getAttribute("user");
        //未支付的状态码
        int ostatus = 1;
        //更新数量，可以后期根据具体需求修改
        int num = 1;
        //查询是否数据库已有未支付的同款商品
        Hotel hotel = findByIdAndUid(id, uid, ostatus);
        //如果查询数据不为空则修改数量
        if (hotel != null) {
            return updateNum(hotel.getId(), num);
        }
        //查询对应酒店的单价数据
        hotel = hotelBiz.findById(id);
        double oprice = hotel.getPrice();
        return orderMapper.add(id, uid, oprice);
    }

    /**
     * 根据商品号，用户编号和状态号查询购物车中是否有未支付的该商品号的商品，
     * 来判断是插入新数据还是更新数据的数量
     *
     * @param ocid 商品号
     * @param uid 用户编号
     * @param ostatus 状态号
     * @return
     */
    @Override
    public Hotel findByIdAndUid(Integer ocid, Integer uid, Integer ostatus) {
        return orderMapper.findByIdAndUid(ocid, uid, ostatus);
    }

    /**
     * 更新订单的商品数量
     *
     * @param id 订单号
     * @param num 修改数量
     * @return
     */
    @Override
    public int updateNum(Integer id, Integer num) {
        return orderMapper.updateNum(id, num);
    }
}
