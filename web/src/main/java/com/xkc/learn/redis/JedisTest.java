package com.xkc.learn.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;

/**
 * Java连接Jedis
 */
public class JedisTest {
    Jedis jedis = null;

    @Before
    public void init() {
        // 1.获取连接
        jedis = new Jedis("localhost", 6379);
    }

    @After
    public void destroy() {
        // 3.关闭连接
        jedis.close();
    }

    @Test
    public void testString() {
        // 2.操作
        jedis.set("username", "Xu");

        String username = jedis.get("username");

        System.out.println(username);

        // setex() 设置过期时间
        jedis.setex("activecode", 3, "ASFIUGSVBUVGUS");

        String activecode = jedis.get("activecode");
        System.out.println(activecode);
    }

    @Test
    public void testHash() {
        jedis.hset("map", "name", "XKC");
        jedis.hset("map", "age", "22");

        String hget = jedis.hget("map", "name");
        System.out.println(hget);

        Map<String, String> map = jedis.hgetAll("map");
        System.out.println(map.toString());
    }

    @Test
    public void testList() {
        jedis.lpush("list", "aaa", "bbb", "ccc");
        jedis.rpush("list", "aaa", "bbb", "ccc");

        List<String> list = jedis.lrange("list", 0, 10);
        list.forEach(System.out::println);
    }

    @Test
    public void testSortedSet() {
        jedis.zadd("sort", 10, "a");
        jedis.zadd("sort", 9, "s");
        jedis.zadd("sort", 8, "g");
        jedis.zadd("sort", 5, "t");
        jedis.zadd("sort", 6, "e");
        jedis.zadd("sort", 7, "n");
        jedis.zadd("sort", 8, "c");
    }

    @Test
    public void MyJedisPool() {
        // 创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(25);
        jedisPoolConfig.setMaxIdle(10);

        // 创建连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        // 获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("test", "testtesttest");

        jedis.close();
    }

    @Test
    public void testJedisPool() {
        // 获取连接
        Jedis jedis = JedisUtils.getJedis();

        jedis.set("JedisUtils", "JedisUtils");

        JedisUtils.close(jedis);
    }
}
