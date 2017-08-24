package com.maizhong.youpin.dao;

import java.util.List;

/**
 * Jedis 接口
 * Created by Xushd on 2017/2/28.
 */
public interface JedisClient {

    String get(String key);

    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long del(String key);

    long hdel(String hkey, String key);

    /**
     * 自增
     * @param key
     * @return
     */
    long incr(String key);

    /**
     * 设置过期
     * @param key
     * @param second
     * @return
     */
    long expire(String key, int second);

    /**
     * 查询是否过期 -2过期 -1 永久
     * @param key
     * @return
     */
    long ttl(String key);

    /**
     * * 获取list对象
     * @param key
     * @param clazz
     * @param start
     * @param end
     * @param <T>
     * @return
     */

    <T> List<T> getObjectList(String key, Class<T> clazz, int start, int end);

    /**
     * 设置list对象
     * @param key
     * @param value
     * @return
     */
    long setObjectList(String key, List<?> value);

    /**
     * 存储REDIS队列 顺序存储
     * @param key reids键名
     * @param value 键值
     */
    void lpush(byte[] key, byte[] value);

    /**
     * 获取队列数据
     * @param  key 键名
     * @return
     */
    byte[] rpop(byte[] key);

    /**
     * 获取集合的长度
     * @param key
     * @return
     */
    long llen(byte[] key);

    /**
     * 取出所有集合
     * @param key
     * @return
     */
    List<byte[]> lrange(byte[] key);




}
