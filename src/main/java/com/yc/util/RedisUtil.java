package com.yc.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @author wk
 * @date 2019/9/25  14:40
 */
public class RedisUtil {

    private static JedisPool jedisPool = null;

    //初始化redis连接池
    static{
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数,可以创建3000jedis实例 
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);
        //等待可用连接的最大时间
        config.setMaxWaitMillis(2000);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }

    /**
          * 获取Jedis实例
          * 每次用完要将连接返回给连接池 jedis.close();
          */
    public synchronized static Jedis getJedis(){
        if(jedisPool != null){
            Jedis resource = jedisPool.getResource();
            return resource;
        }else{
            return null;
        }
    }

    /**
     * 关闭连接功能
     * @param jedis
     */
    public static void close(Jedis jedis){
        jedis.close();
    }

    /** 
          * 回收Jedis对象资源 
          *     - 用户redis都要使用该方法释放资源, 否则一直占有实例资源
          * 
          * @param jedis 
          */
    public synchronized static void returnResource(Jedis jedis){
        if(jedis != null){
            jedisPool.close();
        }
    }

}




