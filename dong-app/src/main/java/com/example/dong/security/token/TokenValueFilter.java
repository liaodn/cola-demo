package com.example.dong.security.token;

import com.example.dong.security.OppleUserDetailService;
import com.example.dong.security.SysAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 **/
@Component
public class TokenValueFilter extends OncePerRequestFilter {


    @Autowired
    private OppleUserDetailService oppleUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        UserDetails ud = oppleUserDetailService.loadUserByUsername("admin");
        //token中的用户信息和数据库中的用户信息对比成功后将用户信息加入SecurityContextHolder相当于登陆
        SysAuthenticationToken authentication = new SysAuthenticationToken(ud, null, ud.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }


}
