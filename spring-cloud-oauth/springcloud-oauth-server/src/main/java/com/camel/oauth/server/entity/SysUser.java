package com.camel.oauth.server.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author  * 
 *   ┏ ┓   ┏ ┓
 *  ┏┛ ┻━━━┛ ┻┓
 *  ┃         ┃
 *  ┃    ━    ┃
 *  ┃  ┳┛  ┗┳ ┃
 *  ┃         ┃
 *  ┃    ┻    ┃
 *  ┃         ┃
 *  ┗━━┓    ┏━┛
 *     ┃    ┃神兽保佑
 *     ┃    ┃代码无BUG！
 *     ┃    ┗━━━━━━━┓
 *     ┃            ┣┓
 *     ┃            ┏┛
 *     ┗┓┓┏━━━━━━┳┓┏┛
 *      ┃┫┫      ┃┫┫
 *      ┗┻┛      ┗┻┛
 * @since 2019-04-19
 */

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID主键
     */
    @TableId(value = "uid", type = IdType.AUTO)
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
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;
    /**
     * 密码生效时间
     */
    private Date passwordExpiredTime;
    /**
     * 用户登录失败次数
     */
    private Integer loginFailureCount;
    /**
     * 所在部门
     */
    private String szbm;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别(0：男，1：女)
     */
    private String gender;
    /**
     * 所属单位编号
     */
    private String orgNo;
    /**
     * 所属单位名称
     */
    private String orgName;

    private String address;

    private String remark;

    @TableField(exist = false)
    private List<SysRole> roles;

    public List<SimpleGrantedAuthority> roles2Names(String rolePrefix){
        List<SimpleGrantedAuthority> roleNames = new ArrayList<>();
        Iterator<SysRole> iterator = this.roles.iterator();
        while (iterator.hasNext()){
            roleNames.add(new SimpleGrantedAuthority(rolePrefix + iterator.next().getRoleName()));
        }
        return roleNames;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        ", uid=" + uid +
        ", username=" + username +
        ", password=" + password +
        ", nickname=" + nickname +
        ", email=" + email +
        ", mobile=" + mobile +
        ", status=" + status +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", lastLoginTime=" + lastLoginTime +
        ", passwordExpiredTime=" + passwordExpiredTime +
        ", loginFailureCount=" + loginFailureCount +
        ", szbm=" + szbm +
        ", age=" + age +
        ", gender=" + gender +
        ", orgNo=" + orgNo +
        ", orgName=" + orgName +
        ", address=" + address +
        "}";
    }

    public List<String> getRolesName() {
        List<String> roleNames = new ArrayList<>();
        this.getRoles().forEach((role) -> {
            roleNames.add(role.getRoleName().toUpperCase());
        });
        return roleNames;
    }
}
