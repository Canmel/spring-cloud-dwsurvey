package com.camel.redis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedisUser implements Serializable {
    private Integer id;

    private String username;

    private String nickname;

    public RedisUser() {
    }

    public RedisUser(Integer id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
}
