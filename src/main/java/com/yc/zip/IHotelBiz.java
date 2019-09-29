package com.yc.zip;

import com.yc.po.Hotel;


import java.util.List;
import java.util.Map;

public interface IHotelBiz {

    /**
     * 查询商品的前四条数据
     * @return
     */
    public List<Hotel> finds();

    /**
     * 查询全部酒店数据
     * @return
     */
    public List<Hotel> findAll();

    /**
     * 根据星级查询酒店
     * @param start 星级
     * @return
     */
    public List<Hotel> findByStart(String start);

    /**
     * 根据酒店id查看酒店详情
     * @param id 酒店id
     * @return
     */
    public Hotel findById(Integer id);

}
