package com.atguigu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

import java.util.Set;

public class JedisPoolCodeTest {
    public static void main(String[] args) {
        //准备数据
        String ip = "192.168.1.203";
        int port = Protocol.DEFAULT_PORT;
        //创建连接池对象
        JedisPool jedisPool = new JedisPool(ip, port);
        //获取连接对象
        Jedis jedis = jedisPool.getResource();
        //操作
        String ping = jedis.ping();
        System.out.println(ping);

        Set<String> animal = jedis.keys("animal");
        System.out.println(animal);
        //关闭连接
        jedis.close();
        //关闭连接池
        jedisPool.close();
    }
}
//feature-good 分支（分支修改）
//feature-good 分支（master）