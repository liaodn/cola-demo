package com.example.dong.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class SysAuthGrant implements GrantedAuthority {


    private String identity;  //权限标识

    public SysAuthGrant(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String getAuthority() {
        return this.identity;
    }
}
