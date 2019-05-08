package com.camel.dwsurvey.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.camel.dwsurvey.system.model.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
public interface SysRoleService extends IService<SysRole> {
    PageInfo<SysRole> pageQuery(SysRole sysRole);

    List<SysRole> loadRolesByRoleIds(List<Integer> ids);
}
