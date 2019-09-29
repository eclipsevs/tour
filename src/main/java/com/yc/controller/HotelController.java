package com.yc.controller;

import com.yc.po.Hotel;
import com.yc.zip.impl.HotelBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public List<Hotel> findByStart(String start,Integer pageNum) {
        List<Hotel> list = new ArrayList<>();
        int pageSize = 12;
        int firstPage = (pageNum-1)*pageSize;
        int endPage = pageNum*pageSize;
        int star = Integer.parseInt(start);
        //获取模板中的缓存数据
        ValueOperations<Integer,List> string = redisTemplate.opsForValue();
        //判断缓存中是否有对应的键，若果有就从redis中查询，没有就从数据库中查询，然后设置到redis中
        if (redisTemplate.hasKey(star)){
            System.out.println("从redis中查询");
            list = string.get(star);
        }else {
            System.out.println("从数据库中查询");
            string.set(star,biz.findByStart(start));
            return biz.findByStart(start);
        }
        return list.subList(firstPage,endPage);
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
