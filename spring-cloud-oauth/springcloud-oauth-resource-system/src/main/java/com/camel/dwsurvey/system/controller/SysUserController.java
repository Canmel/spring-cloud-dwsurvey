package com.camel.dwsurvey.system.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.dwsurvey.system.model.SysUser;
import com.camel.dwsurvey.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseCommonController{

    @Autowired
    private SysUserService userService;

    @GetMapping
    public Result index(SysUser sysUser){
        return ResultUtil.success(userService.pageQuery(sysUser));
    }

    @PostMapping
    public Result save(@RequestBody SysUser sysUser) {
        return super.save(sysUser);
    }

    @GetMapping("/{id}")
    public Result save(@PathVariable(required = true) Integer id){
        Result result = super.details(id);
        SysUser user = (SysUser) result.getData();
        user.setPassword("");
        return ResultUtil.success(user);
    }

    @PutMapping
    public Result update(@RequestBody SysUser sysUser){
        return super.update(sysUser);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(required = true) Integer id){
        return ResultUtil.success(super.delete(id));
    }

    @Override
    public IService getiService() {
        return userService;
    }

    @Override
    public String getMouduleName() {
        return "用户";
    }
}

