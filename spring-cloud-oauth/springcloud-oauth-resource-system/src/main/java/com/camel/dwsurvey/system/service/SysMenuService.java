package com.camel.dwsurvey.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.camel.dwsurvey.system.model.SysMenu;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

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

    List<SysMenu> tops();

    List<SysMenu> subs();

    boolean exist(String name, Integer id);

    boolean delete(Serializable serializable);
}
