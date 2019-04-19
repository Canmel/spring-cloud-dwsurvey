package com.camel.core.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;


@Data
public class BasePaginationEntity {

    @TableField(exist = false)
    private Integer pageNum;

    @TableField(exist = false)
    private Integer pageSize;

    public BasePaginationEntity(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public BasePaginationEntity() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
