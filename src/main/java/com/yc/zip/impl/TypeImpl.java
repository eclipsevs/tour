package com.yc.zip.impl;

import com.yc.zip.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
/**
 * @author wk
 * @date 2019/9/25  19:51
 */
@Service
public class TypeImpl implements Type {

    @Autowired
    RedisTemplate redisTemplate = new RedisTemplate();

    /**
     * 通过某个key获取值
     * @param key
     * @return
     */
    @Override
    public String getString(String key) {
        ValueOperations<String, String> string = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)){
            //在redis中取出并返回
            return string.get(key);
        }else {
            //查询数据库
        }
        return null;
    }
}
