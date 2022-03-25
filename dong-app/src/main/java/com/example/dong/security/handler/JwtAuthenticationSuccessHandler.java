package com.example.dong.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功，以json格式返回给前端的处理器
 **/
@Slf4j
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final AuthorizationServerTokenServices authorizationServerTokenServices;


    public JwtAuthenticationSuccessHandler(AuthorizationServerTokenServices authorizationServerTokenServices) {
        this.authorizationServerTokenServices = authorizationServerTokenServices;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        OAuth2AccessToken token = createToken(authentication);
        log.info(token.toString());
        response.getWriter().println("success login");
    }


    private OAuth2AccessToken createToken(Authentication authentication) {
        OAuth2Request oAuth2Request = new OAuth2Request(null, "100", null, true, null, null, null, null, null);
        OAuth2Authentication auth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        return authorizationServerTokenServices.createAccessToken(auth2Authentication);
    }

}
