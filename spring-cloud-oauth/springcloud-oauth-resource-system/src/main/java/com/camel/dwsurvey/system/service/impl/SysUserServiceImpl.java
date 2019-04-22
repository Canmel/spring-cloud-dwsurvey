package com.camel.dwsurvey.system.service.impl;

import com.camel.dwsurvey.system.model.SysUser;
import com.camel.dwsurvey.system.mapper.SysUserMapper;
import com.camel.dwsurvey.system.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> pageQuery(SysUser entity) {
        PageInfo pageInfo = PageHelper.startPage(entity.getPageNum(), entity.getPageSize()).doSelectPageInfo(()-> sysUserMapper.list(entity));
        return pageInfo;
    }
}
