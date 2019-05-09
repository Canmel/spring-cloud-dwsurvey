package com.camel.dwsurvey.system.model;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.camel.core.entity.BasePaginationEntity;
import lombok.Data;

import java.io.Serializable;

/**
 <p>
 </p>
 @author ${author}
 @since 2019-05-09 */
@Data
public class SysLog extends BasePaginationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     用户ID
     */
    private Integer userId;
    /**
     用户名
     */
    private String username;
    /**
     操作
     */
    private String operation;
    /**
     响应时间
     */
    private Long time;
    /**
     IP地址
     */
    private String ip;
    /**
     请求方法
     */
    private String method;
    /**
     请求参数
     */
    private String params;
    /**
     创建时间
     */
    private Date gmtCreate;
    /**
     模块名称
     */
    private String module;

    public SysLog() {
    }

    public SysLog(Integer userId, String username, String operation, Long time, String ip, String method, String params, String module) {
        this.userId = userId;
        this.username = username;
        this.operation = operation;
        this.time = time;
        this.ip = ip;
        this.method = method;
        this.params = params;
        this.module = module;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                ", id=" + id +
                ", userId=" + userId +
                ", username=" + username +
                ", operation=" + operation +
                ", time=" + time +
                ", ip=" + ip +
                ", method=" + method +
                ", params=" + params +
                ", gmtCreate=" + gmtCreate +
                ", module=" + module +
                "}";
    }
}
