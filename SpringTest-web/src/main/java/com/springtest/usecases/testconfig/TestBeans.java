package com.springtest.usecases.testconfig;

import com.springtest.usecases.system.configuration.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс для тестирования работы контекста
 */
public class TestBeans {

//    public static void main(String[] args) {
//        // инициализация контекста
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        /**
//         * Получение обычного бина из контекста
//         */
//        String testString = (String) context.getBean("getString");
//
//        /**
//         * Получение бина из контекста и назначение ему параметров
//         * Такое возможно только с аннотацией @Lazy  - тогда бин будет создаваться не в момент деплоя, а в тот момент, когда он понадобится
//         */
//        String testLazy = (String) context.getBean("getLazy", "testLazy");
//
//
//        System.out.println(testString);
//        System.out.println(testLazy);
//    }
}
