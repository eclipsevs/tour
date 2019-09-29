package com.yc.zip.impl;



import com.yc.dao.HotelMapper;
import com.yc.po.Hotel;
import com.yc.zip.IHotelBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelBizImpl implements IHotelBiz {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<Hotel> finds() {
        return  hotelMapper.finds();
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Hotel> findAll() {
        return  hotelMapper.findAll();
    }

    /**
     * 根据星级查询
     * @param start 星级
     * @return
     */
    @Override
    public List<Hotel> findByStart(String start) {
        return hotelMapper.findByStart(start);
    }

    /**
     * 根据酒店id查询
     * @param id 酒店id
     * @return
     */
    @Override
    public Hotel findById(Integer id) {
        return hotelMapper.findById(id);
    }


}
