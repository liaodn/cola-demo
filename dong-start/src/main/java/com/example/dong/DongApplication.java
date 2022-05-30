package com.example.dong;

import com.example.dong.config.DongProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Slf4j
public class DongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongApplication.class, args);
    }

    @Component
    public static class Lis implements SpringApplicationRunListener{
        @Override
        public void running(ConfigurableApplicationContext context) {
            log.info("spring 启动成功");
        }
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
