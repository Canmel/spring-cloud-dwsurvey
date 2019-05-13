package com.camel.redis.exceptions;

public class RedisServiceNotFound extends RuntimeException {
    public RedisServiceNotFound() {
        super("未发现可用的Redis服务器！请检查");
    }
}
