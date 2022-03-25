package com.example.dong.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class OppleUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        Collection<SysAuthGrant> grants = new ArrayList<>();
        grants.add(new SysAuthGrant("ROLE_MENU1"));
        grants.add(new SysAuthGrant("ROLE_MENU2"));
        grants.add(new SysAuthGrant("ROLE_MENU3"));

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("loginName", "liaodongnian");
        return new SysUser("admin", "123456", grants, userInfo);
    }
}
