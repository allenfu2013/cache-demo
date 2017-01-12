package org.allen.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

public class MsgProvider {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider.xml");
        RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 18);
        redisTemplate.convertAndSend("topic", data);
    }
}
