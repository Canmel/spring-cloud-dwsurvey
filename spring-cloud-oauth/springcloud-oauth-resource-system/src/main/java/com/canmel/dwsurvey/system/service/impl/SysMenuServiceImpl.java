package com.canmel.dwsurvey.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.camel.core.utils.PaginationUtil;
import com.canmel.dwsurvey.system.mapper.SysMenuMapper;
import com.canmel.dwsurvey.system.model.SysMenu;
import com.canmel.dwsurvey.system.service.SysMenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 <p>
 服务实现类
 </p>
 @author ${author}
 @since 2019-04-19 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public PageInfo<SysMenu> selectPage(SysMenu entity) {
        PageInfo pageInfo = PaginationUtil.startPage(entity, () -> {
            sysMenuMapper.list(entity);
        });
        return pageInfo;
    }
}
