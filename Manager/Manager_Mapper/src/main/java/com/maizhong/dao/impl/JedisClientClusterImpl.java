package com.maizhong.dao.impl;



import com.maizhong.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * JREDIS Daoimpl 集群
 *
 * @author Xushd
 * @since 2017/1/17 0017 下午 1:58
 */
public class JedisClientClusterImpl implements JedisClient {

    @Autowired
    private JedisCluster jedisCluster;


    public String get(String key) {
        return jedisCluster.get(key);
    }

    public String set(String key, String value) {
        return jedisCluster.set(key,value);
    }


    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }


    public long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key, value);
    }


    public long del(String key) {
        return jedisCluster.del(key);
    }


    public long hdel(String hkey, String key) {
        return jedisCluster.hdel(hkey,key);
    }


    public long incr(String key) {
        return jedisCluster.incr(key);
    }


    public long expire(String key, int second) {
        return jedisCluster.expire(key, second);
    }


    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }
}
