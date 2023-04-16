package com.springtest.testconfig;

import com.springtest.system.configuration.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Тестирование создания бинов в контексте
 */
public class TestBeans {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String testContext = (String) context.getBean("getString");
        System.out.println(testContext);
    }
}
