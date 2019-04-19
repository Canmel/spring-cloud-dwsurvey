package com.canmel.dwsurvey.system.controller;


import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.canmel.dwsurvey.system.model.SysMenu;
import com.canmel.dwsurvey.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping
    public Result test(SysMenu sysMenu){
        return ResultUtil.success(sysMenuService.selectPage(sysMenu));
    }
}

