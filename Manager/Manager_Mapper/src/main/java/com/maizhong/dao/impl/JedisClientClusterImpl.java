package com.maizhong.dao.impl;


import com.google.common.collect.Lists;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

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


    public List<String> lrange(String key, int start, int end) {
        return jedisCluster.lrange(key,start,end);
    }

    /**
     * 获取List缓存
     * @param key
     * @param clazz
     * @param start
     * @param end
     * @param <T>
     * @return
     */
    public <T> List<T> getObjectList(String key,Class<T> clazz,int start,int end) {
        List<T> value = null;
        try {
            List<String> lrange = jedisCluster.lrange(key, start, end);
            value = new ArrayList<>();
            for (String s : lrange) {
                value.add(JsonUtils.jsonToPojo(s,clazz));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return value;
    }

    /**
     * 设置list
     * @param key
     * @param value
     * @return
     */
    public long setObjectList(String key, List<?> value) {
        long result = 0;
        try {
            List<String> list = Lists.newArrayList();
            String[] arry = new String[list.size()];
            for (Object o : value) {
                list.add(JsonUtils.objectToJson(o).toString());
            }
            result = jedisCluster.rpush(key, list.toArray(arry));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }


}
