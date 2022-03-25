package com.example.dong.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SysAuthenticationUserDetailsService implements AuthenticationUserDetailsService<AbstractAuthenticationToken> {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserDetails(AbstractAuthenticationToken abstractAuthenticationToken) throws UsernameNotFoundException {
        return userDetailsService.loadUserByUsername((String) abstractAuthenticationToken.getPrincipal());
    }

}
