package com.camel.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID主键
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称/姓名
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 状态(0：已删除，1：正常)
     */
    private String status;

    public User() {
    }

    public User(Integer uid, String username, String password, String nickname, String email, String mobile, String status) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
    }
}
