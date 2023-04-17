package com.springtest.testxmlcontext;

import com.springtest.model.core.Role;
import com.springtest.system.configuration.TestXmlConfig;
import com.springtest.model.entity.User;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Класс для тестирования бинов созданных через xml
 */
public class TestXmlContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring.context/context.xml");
        context.refresh();

        // получение объекта из xml контекста
        TestXmlConfig testConfig = (TestXmlConfig) context.getBean("TestXmlConfig");


        User user = (User) context.getBean("user");
        user.setRole(Role.ADMIN);
        String testXmlConfigOnString = testConfig.getTestStringFromXmlContext();
        System.out.println(testXmlConfigOnString);
        System.out.println(user.getRole());
    }
}
