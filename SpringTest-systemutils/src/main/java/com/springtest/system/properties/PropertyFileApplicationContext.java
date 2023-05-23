package com.springtest.system.properties;

import com.springtest.usecases.usecase.TestRobotUseCase;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Класс для работы со своим кастомным контекстом (находится тут: SpringTest-systemutils/src/main/resources/spring.context/context.properties)
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String filename) {
         PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
         // загрузка всех объявление бинов из файла, который я передам в пути
         int i = reader.loadBeanDefinitions(filename);
        System.out.println("found " + i + " beans");
        refresh();
    }

    public static void main(String[] args) {

        PropertyFileApplicationContext context =  new PropertyFileApplicationContext("spring.context/context.properties");
        context.getBean(TestRobotUseCase.class).sayRobot();



    }
}
