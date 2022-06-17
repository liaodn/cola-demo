package com.example.dong.beandefinition;

import com.example.dong.beandefinition.my.MyScanner;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/31 12:10 下午
 **/
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //direct AbstractBeanDefinition
        AbstractBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Person.class);
        beanDefinition.getPropertyValues().add("name","人类1");
        registry.registerBeanDefinition("test1",beanDefinition);

        //BeanDefinitionBuilder
        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        builder.addPropertyValue("name","人类2");
        registry.registerBeanDefinition("test2", builder.getBeanDefinition());

        //custom @My
        MyScanner scanner = new MyScanner(registry,false);

        int count = scanner.scan("com.example.dong.beandefinition.my");
        System.out.println("自定义扫描:" + count);
    }
}
