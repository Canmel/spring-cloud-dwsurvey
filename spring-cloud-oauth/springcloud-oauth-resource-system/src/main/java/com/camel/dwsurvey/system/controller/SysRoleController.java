package com.camel.dwsurvey.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.dwsurvey.system.model.SysRole;
import com.camel.dwsurvey.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
@RestController
@RequestMapping(("/sysRole"))
public class SysRoleController extends BaseCommonController {

    @Autowired
    private SysRoleService service;

    @Override
    public IService getiService() {
        return service;
    }

    @Override
    public String getMouduleName() {
        return "角色";
    }

    @GetMapping
    public Result index(SysRole sysUser){
        return ResultUtil.success(service.pageQuery(sysUser));
    }

    @PostMapping
    public Result save(SysRole sysRole){
        return super.save(sysRole);
    }

    @PutMapping
    public Result update(SysRole sysRole){
        return super.update(sysRole);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable(required = true) Integer id){
        return super.details(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(required = true) Integer id){
        return super.delete(id);
    }

    @GetMapping("/all/list")
    public Result all(){
        System.out.println(service.selectList(new EntityWrapper<>()));
        return ResultUtil.success(service.selectList(new EntityWrapper<>()));
    }
}

