package com.example.dong.security.token;

import com.example.dong.security.SysAuthenticationToken;
import com.example.dong.security.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.Collections;
import java.util.Map;

@Slf4j
public class JwtUserAuthenticationConverter implements UserAuthenticationConverter {

    private final UserDetailsService userDetailsService;

    public JwtUserAuthenticationConverter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof SysUser) {
            Map<String, ?> userInfo = ((SysUser) principal).getUserInfo();
            return Collections.unmodifiableMap(userInfo);
        }
        return Collections.emptyMap();
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        String username = (String) map.get("loginName");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        SysAuthenticationToken token = new SysAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        token.eraseCredentials();
        return token;
    }
}
