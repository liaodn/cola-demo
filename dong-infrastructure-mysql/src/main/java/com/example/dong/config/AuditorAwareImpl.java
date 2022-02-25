package com.example.dong.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/2/25 4:21 PM
 * 审计
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("liaodongnian");
    }
}
