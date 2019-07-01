package com.camel.dwsurvey.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.camel.core.entity.BasePaginationEntity;
import com.camel.dwsurvey.system.enums.RoleStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
@Data
public class SysUserRole extends BasePaginationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 状态(0：已删除，1：正常)
     */
    private String status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

    public SysUserRole() {
    }

    public SysUserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
        this.status = RoleStatus.NORMAL.getCode();
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        ", id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", status=" + status +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
