package com.example.dong.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SysUser extends User {

    private Map<String, String> userInfo;

    public SysUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Map<String, String> userInfo) {
        super(username, password, authorities);
        this.userInfo = userInfo;
    }

    public SysUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Map<String, String> userInfo) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userInfo = userInfo;
    }

    public Map<String, String> getUserInfo() {
        return userInfo;
    }
}
