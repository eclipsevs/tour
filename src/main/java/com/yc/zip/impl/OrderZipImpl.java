package com.yc.zip.impl;

import com.yc.dao.OrderMapper;
import com.yc.po.Order;
import com.yc.zip.OrderZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  14:39
 */
@Service
public class OrderZipImpl implements OrderZip {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Object> findAll(Integer ostatus, Integer uid) {
        List<Object> list = orderMapper.findAll(ostatus,uid);
        return list;
    }

    @Override
    public int updateStatus(List<Order> list) {
        return orderMapper.updateStatus(list);
    }

    @Override
    public int delete(Integer oid) {
        return orderMapper.delete(oid);
    }
}
