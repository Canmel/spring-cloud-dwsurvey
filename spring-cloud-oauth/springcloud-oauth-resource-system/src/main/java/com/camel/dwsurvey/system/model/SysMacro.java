package com.camel.dwsurvey.system.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.camel.core.entity.BasePaginationEntity;
import com.camel.dwsurvey.system.enums.MacroStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-05-15
 */
@Data
public class SysMacro extends BasePaginationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "macro_id", type = IdType.AUTO)
    private Integer macroId;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 类别/参数编码
     */
    private String code;
    /**
     * 类别/参数名称
     */
    private String name;
    /**
     * 参数值
     */
    private String value;
    /**
     * 状态(0:已删除，1:正常)
     */
    private Integer status;

    @TableField(exist = false)
    private MacroStatus macroStatus;
    /**
     * 类型,0:参数类别，1:参数配置
     */
    private Integer type;
    /**
     * 排序号
     */
    private Integer orderNum;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private String gmtCreate;
    /**
     * 更新时间
     */
    private String gmtModified;
    /**
     * 字典可删除（0:可删除，1：不可删除）
     */
    private Integer deletable;

    @Override
    public String toString() {
        return "SysMacro{" +
        ", macroId=" + macroId +
        ", parentId=" + parentId +
        ", code=" + code +
        ", name=" + name +
        ", value=" + value +
        ", status=" + status +
        ", type=" + type +
        ", orderNum=" + orderNum +
        ", remark=" + remark +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", deletable=" + deletable +
        "}";
    }
}
