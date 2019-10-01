package com.yc.zip.impl;


import com.yc.dao.HotelMapper;
import com.yc.po.Hotel;
import com.yc.zip.IHotelBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class HotelBizImpl implements IHotelBiz {

    @Autowired
    private HotelMapper hotelMapper;
    /**
     * 自动装配RedisTemplate
     */
    @Autowired
    RedisTemplate redisTemplate = new RedisTemplate();

    @Override
    public List<Hotel> finds() {
        return hotelMapper.finds();
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Hotel> findAll() {
        //获取模板中的缓存数据
        String str = "six";
        ValueOperations<String, List> list = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(str)) {
            //判断缓存中是否有对应的键，若果有就从redis中查询，没有就从数据库中查询，然后设置到redis中
            return list.get(str);
        } else {
            list.set(str, hotelMapper.findAll());
            return hotelMapper.findAll();
        }
    }

    /**
     * 根据星级查询
     *
     * @param start 星级
     * @param pageNum 页数
     * @return
     */
    @Override
    public List<Hotel> findByStart(String start,Integer pageNum) {
        pageNum = (pageNum-1)*6;
        return hotelMapper.findByStart(start,pageNum);
    }

    /**
     * 根据酒店id查询
     *
     * @param id 酒店id
     * @return
     */
    @Override
    public Hotel findById(Integer id) {
        return hotelMapper.findById(id);
    }


}
