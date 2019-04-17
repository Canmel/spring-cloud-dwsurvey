package com.camel.oauth.resource.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */
@TableName("t_user")
@Data
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String activationCode;
    private Date birthday;
    private String cellphone;
    private String createBy;
    private Date createTime;
    private Integer eduQuali;
    private String email;
    private String findPwdCode;
    private Date findPwdLastDate;
    private Date lastLoginTime;
    private String loginName;
    private String name;
    private String salt;
    private Integer sex;
    private String shaPassword;
    private Integer status;
    private Integer version;

    @Override
    public String toString() {
        return "TUser{" +
        ", id=" + id +
        ", activationCode=" + activationCode +
        ", birthday=" + birthday +
        ", cellphone=" + cellphone +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", eduQuali=" + eduQuali +
        ", email=" + email +
        ", findPwdCode=" + findPwdCode +
        ", findPwdLastDate=" + findPwdLastDate +
        ", lastLoginTime=" + lastLoginTime +
        ", loginName=" + loginName +
        ", name=" + name +
        ", salt=" + salt +
        ", sex=" + sex +
        ", shaPassword=" + shaPassword +
        ", status=" + status +
        ", version=" + version +
        "}";
    }
}
