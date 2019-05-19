package com.camel.redis.exceptions;

public class RedisServiceNotFoundException extends RuntimeException {
    public RedisServiceNotFoundException() {
        super("未发现可用的Redis服务器！请检查");
    }
}
