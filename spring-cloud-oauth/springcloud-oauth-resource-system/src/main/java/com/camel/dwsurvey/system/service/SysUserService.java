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
    /**
     * 用户分页查询
     * @param user
     * @return
     */
    PageInfo<SysUser> pageQuery(SysUser user);

    /**
     * 判断用户是否存在
     * @param name
     * @param id
     * @return
     */
    boolean exist(String name, Integer id);

    /**
     * 获取用户的所有角色
     * @param user
     */
    void getRolesByUser(SysUser user);

    /**
     * 给用户添加角色
     * @param user
     * @return
     */
    boolean addRoles(SysUser user);
}
