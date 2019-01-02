package cn.bdqn.util;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisAPI  {
    private JedisPool jedisPool;

    public  RedisAPI(JedisPool jedisPool){
        this.jedisPool=jedisPool;
    }
    /**
     * set key and value to redis
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value){
        try{
            Jedis jedis = jedisPool.getResource();
            jedis.set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 判断某个key是否存在
     * @param key
     * @return
     */
    public boolean exist(String key){
        try{
            Jedis jedis = jedisPool.getResource();
            return jedis.exists(key);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 获取数据
     * @param key
     * @return
     */
    public String get(String key){
        String value = null;
        Jedis jedis = null;
        try{
            jedis =jedisPool.getResource();
            value = jedis.get(key);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
          if(jedis!=null){
              jedis.close();
          }
        }
        return value;
    }


}
