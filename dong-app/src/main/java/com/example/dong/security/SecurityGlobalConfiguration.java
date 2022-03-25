package com.example.dong.security;

import com.example.dong.security.token.JwtUserAuthenticationConverter;
import com.example.dong.security.token.UserInfoJwtAccessTOkenConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class SecurityGlobalConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DefaultTokenServices tokenServices(TokenStore tokenStore, JwtAccessTokenConverter converter) {
        //OAuth2AuthenticationProcessingFilter
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setTokenEnhancer(converter);
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds(2 * 60 * 60);
        tokenServices.setRefreshTokenValiditySeconds(2 * 60 * 60 * 24);

        return tokenServices;
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenStore tokenStore(JwtAccessTokenConverter converter) {
        return new JwtTokenStore(converter);
    }

    @Bean
    @ConditionalOnMissingBean
    public JwtAccessTokenConverter jwtAccessTokenConverter(UserAuthenticationConverter userAuthenticationConverter) {
        JwtAccessTokenConverter converter = new UserInfoJwtAccessTOkenConverter();
        converter.setSigningKey("xxx");
        ((DefaultAccessTokenConverter) converter.getAccessTokenConverter()).setUserTokenConverter(userAuthenticationConverter);
        return converter;
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public UserAuthenticationConverter userAuthenticationConverter(UserDetailsService userDetailsService) {
        return new JwtUserAuthenticationConverter(userDetailsService);
    }
}
