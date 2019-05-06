package com.camel.dwsurvey.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.camel.dwsurvey.system.mapper.SysRoleMapper;
import com.camel.dwsurvey.system.model.SysRole;
import com.camel.dwsurvey.system.service.SysRoleService;
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
 * @since 2019-04-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public PageInfo<SysRole> pageQuery(SysRole entity) {
        PageInfo pageInfo = PageHelper.startPage(entity.getPageNum(), entity.getPageSize()).doSelectPageInfo(()-> roleMapper.list(entity));
        return pageInfo;
    }
}
