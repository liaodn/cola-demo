package com.example.dong.security;

import com.example.dong.security.handler.JwtAuthenticationFailureHandler;
import com.example.dong.security.handler.JwtAuthenticationSuccessHandler;
import com.example.dong.security.token.TokenValueFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OppleUserDetailService oppleUserDetailService;

    @Autowired
    private TokenValueFilter tokenValueFilter;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/api/**")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable().cors()
                .and().addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(tokenValueFilter, SysAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(oppleUserDetailService)
//                .passwordEncoder(new PasswordEncoder() {
//                    @Override
//                    public String encode(CharSequence charSequence) {
//                        return String.valueOf(charSequence);
//                    }
//
//                    @Override
//                    public boolean matches(CharSequence charSequence, String s) {
//                        return true;
//                    }
//                });
//    }

    private SysAuthenticationFilter authenticationFilter() throws Exception {
        SysAuthenticationFilter filter = new SysAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler(authorizationServerTokenServices));
        filter.setAuthenticationFailureHandler(new JwtAuthenticationFailureHandler());
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }
}
