package com.canmel.dwsurvey.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.canmel.dwsurvey.system.model.SysMenu;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
public interface SysMenuService extends IService<SysMenu> {
    PageInfo<SysMenu> selectPage(SysMenu sysMenu);
}
