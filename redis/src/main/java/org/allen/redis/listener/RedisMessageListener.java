package org.allen.redis.listener;

import java.io.Serializable;

public class RedisMessageListener {

    public void handleMessage(Serializable message) {
        System.out.println(message);
    }
}
