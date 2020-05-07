package com.atguigu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;

import java.util.List;

public class RedisCodeTest {
    public static void main(String[] args) {
        //准备参数
        String ip = "192.168.1.203";
        int port = Protocol.DEFAULT_PORT;
        //创建连接对象
        Jedis jedis = new Jedis(ip, port);
        //调用Jedis对象的方法操作Redis服务器
        String ping = jedis.ping();
        System.out.println("1-->" + ping);

        Long pushResult = jedis.lpush("animal", "dog","cat", "pig");
        System.out.println("2-->" + pushResult);

        List<String> animalList = jedis.lrange("animal", 0, -1);
        for (String s : animalList) {
            System.out.println(s);
        }
        //关闭连接
        jedis.close();

    }
}
