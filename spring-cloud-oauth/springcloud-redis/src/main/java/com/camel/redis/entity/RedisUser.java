package com.camel.redis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 @author baily */
@Data
public class RedisUser implements Serializable {

    private long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String nickname;

    private String address;

    private String mobile;

    private String remark;

    private String email;

    private List<String> roles;

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

    public RedisUser(Integer id, String username, String nickname, String address, String mobile, String remark, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.remark = remark;
        this.email = email;
        this.roles = roles;
    }
}
