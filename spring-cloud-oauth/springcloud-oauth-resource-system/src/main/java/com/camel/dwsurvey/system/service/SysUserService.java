package com.camel.dwsurvey.system.service;

import com.camel.dwsurvey.system.model.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-22
 */
public interface SysUserService extends IService<SysUser> {
    PageInfo<SysUser> pageQuery(SysUser user);
}
