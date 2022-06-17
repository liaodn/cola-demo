package com.example.dong.beandefinition.my;

import com.example.dong.beandefinition.My;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/31 12:41 下午
 **/
public class MyScanner extends ClassPathBeanDefinitionScanner {

    public MyScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
        addIncludeFilter(new AnnotationTypeFilter(My.class));
    }
}
