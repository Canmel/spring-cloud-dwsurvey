package com.camel.core;

import com.baomidou.mybatisplus.service.IService;
import com.camel.core.entity.BaseEntity;
import com.camel.core.entity.BasePaginationEntity;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

public abstract class BaseCommonController {

    abstract public IService getiService();

    abstract public String getMouduleName();

    public Result details(Serializable serializable) {
        Object obj = getiService().selectById(serializable);
        if (ObjectUtils.isEmpty(obj)) {
            return ResultUtil.notFound();
        }
        return ResultUtil.success(obj);
    }

    public Result save(BaseEntity entity) {
        boolean insert = getiService().insert(entity);
        if (insert) {
            return ResultUtil.success("新增" + getMouduleName() + "成功");
        }
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"新增" + getMouduleName() + "失败");
    }

    public Result update(BaseEntity entity) {
        if (getiService().updateById(entity)) {
            return ResultUtil.success("修改" + getMouduleName() + "成功");
        }
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"修改" + getMouduleName() + "失败");
    }

    public Result delete(Serializable serializable) {
        if (getiService().deleteById(serializable)) {
            return ResultUtil.success("删除" + getMouduleName() + "成功");
        }
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"删除" + getMouduleName() + "失败");

    }
}
