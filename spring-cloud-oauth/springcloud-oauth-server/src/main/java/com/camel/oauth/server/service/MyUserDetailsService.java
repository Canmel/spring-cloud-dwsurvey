package com.camel.oauth.server.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.camel.oauth.server.entity.MyUserDetails;
import com.camel.oauth.server.entity.SysRole;
import com.camel.oauth.server.entity.SysUser;
import com.camel.oauth.server.entity.TUser;
import com.camel.oauth.server.enums.EntityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Value("${springcloud.oauth.signin.colum}")
    private String signInColum;

    @Value("${springcloud.oauth.role.prefix}")
    private String rolePrefix;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EntityWrapper<SysUser> userWrapper = new EntityWrapper<>();
        userWrapper.eq(signInColum, s);
        SysUser user = userService.selectOne(userWrapper);
        user.setRoles(roleService.selectRoleByUser(user));
        boolean userAccountNonLocked = !ObjectUtils.isEmpty(user.getLoginFailureCount()) && user.getLoginFailureCount() < 3;
        boolean accountNonExpired = !ObjectUtils.isEmpty(user.getPasswordExpiredTime()) && user.getPasswordExpiredTime().getTime() > new Date().getTime();
        boolean userEnable = EntityStatus.ENABLE.getCode().equals(user.getStatus());
        MyUserDetails myUserDetails = new MyUserDetails(user.getEmail(), user.getPassword(), userEnable, accountNonExpired, true, userAccountNonLocked, user.roles2Names(rolePrefix));
        return myUserDetails;
    }
}
