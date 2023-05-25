package com.springtest.usecases.testconfig;

import com.springtest.usecases.classconfig.usecaseimpl.ColorFrame;
import com.springtest.usecases.system.configuration.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Класс для тестирования работы контекста
 */
public class TestBeans {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        while(true) {
            ColorFrame colorFrame = context.getBean(ColorFrame.class);
            colorFrame.showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
