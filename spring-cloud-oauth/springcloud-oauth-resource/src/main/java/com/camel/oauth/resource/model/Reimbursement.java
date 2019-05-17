package com.camel.oauth.resource.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.camel.core.entity.BasePaginationEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-05-17
 */
@Data
public class Reimbursement extends BasePaginationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 申请名称
     */
    private String name;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 创建人
     */
    private Integer creator;
    private Integer status;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 备注
     */
    private String description;

    @Override
    public String toString() {
        return "Reimbursement{" +
        ", id=" + id +
        ", name=" + name +
        ", amount=" + amount +
        ", creator=" + creator +
        ", status=" + status +
        ", isDel=" + isDel +
        ", description=" + description +
        "}";
    }
}
