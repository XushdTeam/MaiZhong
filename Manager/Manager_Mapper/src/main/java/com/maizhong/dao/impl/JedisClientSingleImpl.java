package com.maizhong.dao.impl;


import com.maizhong.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * JREDIS Daoimpl 单例
 * @author Xushd
 * @since 2017/2/4 0004 下午 1:04
 */
public class JedisClientSingleImpl implements JedisClient {

    //配置文件中配置
    @Autowired
    private JedisPool jedisPool;


    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }


    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String ret = jedis.set(key, value);
        jedis.close();
        return ret;
    }


    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.hget(hkey, key);
        jedis.close();
        return value;
    }


    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.hset(hkey, key, value);
        jedis.close();
        return ret;
    }


    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.del(key);
        jedis.close();
        return ret;
    }


    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.hdel(hkey, key);
        jedis.close();
        return ret;
    }


    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.incr(key);
        jedis.close();
        return ret;
    }


    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.expire(key, second);
        jedis.close();
        return ret;
    }


    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ret = jedis.ttl(key);
        jedis.close();
        return ret;
    }
}
