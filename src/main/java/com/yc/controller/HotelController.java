package com.yc.controller;

import com.yc.po.Hotel;
import com.yc.zip.impl.HotelBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelBizImpl biz;
    /**
     * 自动装配RedisTemplate
     */
    @Autowired
    RedisTemplate redisTemplate = new RedisTemplate();


    @RequestMapping("/finds")
    @ResponseBody
    //查询前最后6条酒店信息
    public List<Hotel> finds() {
        return biz.finds();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    //查看所有酒店信息
    public List<Hotel> findAll() {
        return biz.findAll();
    }


    @RequestMapping("/findByStar")
    @ResponseBody
    //根据星级查询酒店信息
    public List<Hotel> findByStar(String star,Integer pageNum) {
            return biz.findByStar(star,pageNum);
    }

    /**
     * 根据酒店id查询酒店
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    @ResponseBody
    public Hotel findById(Integer id){
        if (id == null) {
            return null;
        }
        return biz.findById(id);
    }

}
