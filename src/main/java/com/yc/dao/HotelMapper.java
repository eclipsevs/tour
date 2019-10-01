package com.yc.dao;

import com.yc.po.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelMapper {
    /**
     * 查询每种id的商品的后六条数据
     * @return
     */
    public List<Hotel> finds();

    /**
     * 根据星级查询
     * @param start
     * @param pageNum
     * @return
     */
    List<Hotel> findByStart(@Param("start") String start, @Param("pageNum") Integer pageNum);
    /**
     * 查看所有酒店
     * @return
     */
    public List<Hotel> findAll();

    /**
     * 根据酒店id查看酒店详情
     * @param id 酒店id
     * @return
     */
    public Hotel findById(Integer id);

}