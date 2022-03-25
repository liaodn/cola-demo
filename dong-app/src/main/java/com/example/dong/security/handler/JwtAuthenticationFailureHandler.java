package com.example.dong.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录错误，以json格式返回给前端的处理器。
 *
 **/
public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //exception.printStackTrace();
        response.getWriter().println("{\n" +
                "\t\"code\":\"10000\",\n" +
                "\t\"fail\":\"失败了\"\n" +
                "}");
    }
}
