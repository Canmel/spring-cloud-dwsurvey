package com.camel.oauth.server.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.camel.oauth.server.entity.MyUserDetails;
import com.camel.oauth.server.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private TUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EntityWrapper<TUser> userWrapper = new EntityWrapper<>();
        userWrapper.eq("email", s);
        TUser tUser = userService.selectOne(userWrapper);
        MyUserDetails myUserDetails = new MyUserDetails(tUser);
        return myUserDetails;
    }
}
