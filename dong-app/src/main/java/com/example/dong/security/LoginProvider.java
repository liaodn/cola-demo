package com.example.dong.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginProvider implements AuthenticationProvider {

    @Autowired
    private SysAuthenticationUserDetailsService sysAuthenticationUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        log.info("登录:{} {}", username, password);
        UserDetails ud = sysAuthenticationUserDetailsService.loadUserDetails((AbstractAuthenticationToken) authentication);

        SysAuthenticationToken token = new SysAuthenticationToken(ud,null,ud.getAuthorities());
        token.setDetails(authentication.getDetails());

        if (username.equals("admin")) {
            return token;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SysAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
