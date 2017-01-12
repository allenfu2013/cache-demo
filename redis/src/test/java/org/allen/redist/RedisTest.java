package org.allen.redist;

import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

public class RedisTest {

    /**
     * key和hashKey使用String的序列化策略
     * value和hashValue使用JDK的序列化策略
     */
    private static RedisTemplate redisTemplate;

    /**
     * key, value, hashKey, hashValue都采用String的序列化策略
     */
    private static StringRedisTemplate stringRedisTemplate;

    @BeforeClass
    public static void before() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test-applicationContext.xml");
        redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
        stringRedisTemplate = (StringRedisTemplate) context.getBean("stringRedisTemplate");
    }

    @Test
    public void testRedisTemplate() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 18);
        redisTemplate.opsForValue().set("key1", data);
        Object value = redisTemplate.opsForValue().get("key1");
        System.out.println(value);
    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("key2", "李四");
        String value = stringRedisTemplate.opsForValue().get("key2");
        System.out.println(value);
    }

    @AfterClass
    public static void afterClass() {
    }

}
