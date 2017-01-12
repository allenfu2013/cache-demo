package org.allen.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MsgConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        System.out.println("consumer started");
    }
}
