package com.camel.dwsurvey.system.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.dwsurvey.system.model.SysMenu;
import com.camel.dwsurvey.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class SysMenuController extends BaseCommonController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping
    public Result index(SysMenu sysMenu){
        return ResultUtil.success(sysMenuService.selectPage(sysMenu));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id){
        return super.details(id);
    }

    @PostMapping
    public Result save(SysMenu sysMenu){
        return super.save(sysMenu);
    }

    @PutMapping
    public Result update(SysMenu sysMenu){
        return super.update(sysMenu);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return super.delete(id);
    }

    @GetMapping("/tops")
    public Result tops(SysMenu sysMenu) {
        return ResultUtil.success("");
    }

    @GetMapping("/subs")
    public Result subs(SysMenu sysMenu){
        return ResultUtil.success("");
    }


    @Override
    public IService getiService() {
        return sysMenuService;
    }

    @Override
    public String getMouduleName() {
        return "菜单";
    }
}

