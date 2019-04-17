package com.camel.core.utils;

import com.camel.core.entity.Result;
import com.camel.core.enums.ResultEnum;

public class ResultUtil {
    public ResultUtil() {
    }

    public static Result success(Object data){
        return success(ResultEnum.SUCCESS.getMsg(), data);
    }

    public static Result success(String msg, Object data){
        return new Result(ResultEnum.SUCCESS.getCode(), msg, data, true);
    }

    public static Result success(String msg) {
        return success(msg, null);
    }
    public static Result success(ResultEnum resultEnum){
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), null, true);
    }

    public static Result error(Integer code, String msg){
        return new Result(code, msg, null, false);
    }

    public static Result error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }
}
