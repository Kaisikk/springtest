package com.springtest.testxmlcontext;

import com.springtest.system.configuration.TestXmlConfig;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Класс для тестирования бинов созданных через xml
 */
public class TestXmlContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring.context/context.xml");
        context.refresh();

        TestXmlConfig testConfig = (TestXmlConfig) context.getBean("TestXmlConfig");
        String testXmlConfigOnString = testConfig.getTestStringFromXmlContext();
        System.out.println(testXmlConfigOnString);
    }
}
