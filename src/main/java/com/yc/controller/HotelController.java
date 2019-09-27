package com.yc.controller;

import com.yc.po.Hotel;
import com.yc.zip.impl.HotelBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    public List<Hotel> findByStart(String start) {
        int star = Integer.parseInt(start);
        ValueOperations<Integer,List> string = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(star)){
            System.out.println("从redis中查询");
            return string.get(star);
        }else {
            System.out.println("从数据库中查询");
            string.set(star,biz.findByStart(start));
            return biz.findByStart(start);
        }
    }

}
