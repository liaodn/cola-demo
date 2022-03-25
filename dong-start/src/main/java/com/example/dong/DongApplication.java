package com.example.dong;

import com.example.dong.config.DongProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Slf4j
public class DongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongApplication.class, args);
    }

    @Component
    public static class Init implements CommandLineRunner {

        private DongProperties dongProperties;

        public Init(ObjectProvider<DongProperties> dongPropertiesObjectProvider) {
            dongPropertiesObjectProvider.ifAvailable(v ->
                    Init.this.dongProperties = v);
        }

        public void run(String... args) throws Exception {
            log.info("spring 初始化");
            log.info(dongProperties.toString());
        }
    }
}
