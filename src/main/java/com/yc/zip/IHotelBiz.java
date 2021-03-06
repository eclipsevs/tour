package com.yc.zip;

import com.yc.po.Hotel;


import java.util.List;
import java.util.Map;

public interface IHotelBiz {

    /**
     * 查询商品的前四条数据
     *
     * @return
     */
    public List<Hotel> finds();

    /**
     * 查询全部酒店数据
     *
     * @return
     */
    public List<Hotel> findAll();

    /**
     * 根据星级查询酒店
     *
     * @param star 星级
     * @param pageNum 页数
     * @return
     */
    public List<Hotel> findByStar(String star,Integer pageNum);

    /**
     * 根据酒店id查看酒店详情
     *
     * @param id 酒店id
     * @return
     */
    public Hotel findById(Integer id);

}
