package com.camel.redis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
import java.io.Serializable;

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
 * @since 2019-03-20
 */
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("activation_code")
    private String activationCode;
    private Date birthday;
    private String cellphone;
    @TableField("create_by")
    private String createBy;
    @TableField("create_time")
    private Date createTime;
    @TableField("edu_quali")
    private Integer eduQuali;
    private String email;
    @TableField("find_pwd_code")
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEduQuali() {
        return eduQuali;
    }

    public void setEduQuali(Integer eduQuali) {
        this.eduQuali = eduQuali;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFindPwdCode() {
        return findPwdCode;
    }

    public void setFindPwdCode(String findPwdCode) {
        this.findPwdCode = findPwdCode;
    }

    public Date getFindPwdLastDate() {
        return findPwdLastDate;
    }

    public void setFindPwdLastDate(Date findPwdLastDate) {
        this.findPwdLastDate = findPwdLastDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getShaPassword() {
        return shaPassword;
    }

    public void setShaPassword(String shaPassword) {
        this.shaPassword = shaPassword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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
