package com.example.dong.security.token;

import com.example.dong.security.SysUser;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class UserInfoJwtAccessTOkenConverter extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessToken result = super.enhance(accessToken, authentication);
        //把用户信息加载扩展中
        Map<String, Object> additionalInformation = result.getAdditionalInformation();
        Object principal = authentication.getPrincipal();
        if (principal instanceof SysUser) {
            additionalInformation.put("userInfo", ((SysUser) principal).getUserInfo());
        }
        return result;
    }
}
