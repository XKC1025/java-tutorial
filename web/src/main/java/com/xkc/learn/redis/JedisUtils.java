package com.xkc.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    private static Properties properties;
    private static JedisPoolConfig jedisPoolConfig;
    private static JedisPool jedisPool;

    private JedisUtils() {

    }

    static {
        properties = new Properties();
        InputStream resourceAsStream = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");

        jedisPoolConfig = new JedisPoolConfig();
        try {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        jedis.close();
    }

}
