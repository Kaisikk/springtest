package com.springtest.testconfig;

import com.springtest.system.configuration.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс для тестирования работы контекста
 */
public class TestBeans {

    public static void main(String[] args) {
        // инициализация контекста
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // получение бина из контекста (в этом случае - переменной)
        String testString = (String) context.getBean("getString");
        String testLazy = (String) context.getBean("getLazy", "testLazy");
        System.out.println(testString);
        System.out.println(testLazy);
    }
}
