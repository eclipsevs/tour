import com.yc.util.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * @author wk
 * @date 2019/9/25  14:43
 */
public class TestRedis {
    public static void main(String[] args) {
        //获取redis连接
        Jedis jedis = RedisUtil.getJedis();
        String key = "aa";
        if (jedis.exists(key)){
            System.out.println(jedis.get(key)+"从redis中获得");
        }else {
            jedis.set("aa", "aa");
            System.out.println("从数据库获得");
        }
        //关闭该连接
        RedisUtil.close(jedis);
    }
}
