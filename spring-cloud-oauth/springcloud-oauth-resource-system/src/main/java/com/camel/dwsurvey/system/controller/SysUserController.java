package com.camel.dwsurvey.system.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.redis.utils.SerizlizeUtil;
import com.camel.dwsurvey.system.annotation.Log;
import com.camel.dwsurvey.system.model.SysUser;
import com.camel.dwsurvey.system.service.SysUserService;
import com.camel.redis.entity.RedisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

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
    private SysUserService service;

    @Autowired
    private RedisTemplate redisTemplate;

    @Log(moduleName = "用户", option = "查询列表")
    @GetMapping
    public Result index(SysUser sysUser){
        return ResultUtil.success(service.pageQuery(sysUser));
    }

    @PostMapping
    public Result save(@RequestBody SysUser sysUser) {
        return super.save(sysUser);
    }

    @GetMapping("/{id}")
    public Result save(@PathVariable(required = true) Integer id){
        Result result = super.details(id);
        SysUser user = (SysUser) result.getData();
        service.getRolesByUser(user);
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

    @GetMapping("/valid/{name}")
    public Result nameValid(@PathVariable String name, Integer id){
        return ResultUtil.success(service.exist(name, id));
    }

    @PostMapping("/roles")
    public Result addRole(@RequestBody SysUser user){
        if (service.addRoles(user)) {
            return ResultUtil.success("修改用户角色成功");
        }
        return ResultUtil.error(400, "修改用户角色失败");
    }

    @GetMapping("/me")
    public Result me(){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        byte[] cu = (byte[]) operations.get("CURRENT_USER");
        RedisUser sysUser = (RedisUser) SerizlizeUtil.unserizlize(cu);
        return ResultUtil.success(sysUser);
    }

    @Override
    public IService getiService() {
        return service;
    }

    @Override
    public String getMouduleName() {
        return "用户";
    }
}

