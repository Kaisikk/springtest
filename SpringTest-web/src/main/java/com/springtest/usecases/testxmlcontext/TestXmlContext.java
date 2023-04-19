package com.springtest.usecases.testxmlcontext;

import com.springtest.usecases.model.core.Role;
import com.springtest.usecases.system.configuration.TestXmlConfig;
import com.springtest.usecases.model.entity.User;
import com.springtest.usecases.usecaseimpl.TestRobotUseCaseImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Класс для тестирования бинов созданных через xml
 */
public class TestXmlContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        // другой способ получение бинов из xml
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.context/context.xml");
        context.load("spring.context/context.xml");
        context.refresh();

        // получение объекта из xml контекста
        TestXmlConfig testConfig = (TestXmlConfig) context.getBean("testXmlConfig");


        User user = (User) context.getBean("user");
        user.setRole(Role.ADMIN);
        String testXmlConfigOnString = testConfig.getTestStringFromXmlContext();
        System.out.println(testXmlConfigOnString);
        System.out.println(user.getRole());

        // получение бина и выполнение его метода
        xmlContext.getBean(TestRobotUseCaseImpl.class).sayRobot();
    }
}
