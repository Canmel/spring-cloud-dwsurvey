package com.camel.redis.entity;

import lombok.Data;

import java.io.Serializable;

/** @author baily */
@Data
public class RedisUser implements Serializable {
    private Integer id;

    private String username;

    private String nickname;

    private String address;

    private String mobile;

    private String remark;

    private String email;

    public RedisUser() {
    }

    public RedisUser(Integer id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

    public RedisUser(Integer id, String username, String nickname, String address, String mobile, String remark, String email) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.remark = remark;
        this.email = email;
    }
}
