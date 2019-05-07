package com.camel.dwsurvey.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.camel.dwsurvey.system.model.SysMenu;
import com.camel.dwsurvey.system.model.SysUser;
import com.camel.dwsurvey.system.mapper.SysUserMapper;
import com.camel.dwsurvey.system.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    private SysUserMapper mapper;

    @Override
    public PageInfo<SysUser> pageQuery(SysUser entity) {
        PageInfo pageInfo = PageHelper.startPage(entity.getPageNum(), entity.getPageSize()).doSelectPageInfo(()-> mapper.list(entity));
        return pageInfo;
    }

    @Override
    public boolean exist(String name, Integer id) {
        Wrapper<SysUser> userWrapper = new EntityWrapper<>();
        userWrapper.eq("username", name);
        if(!ObjectUtils.isEmpty(id)){
            userWrapper.notIn("uid", id);
        }

        Integer count = mapper.selectCount(userWrapper);
        return !(count > 0);
    }
}
