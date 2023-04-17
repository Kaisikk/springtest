package com.springtest.system.configuration;

import org.springframework.stereotype.Component;
import com.springtest.model.entity.User;

/**
 * Класс для тестирования работы контекста прописанно в xml
 *
 */
@Component
public class TestXmlConfig {

    /**
     * Переменная, которую я задал в context.xml
     */
    private String testStringFromXmlContext;

    public String getTestStringFromXmlContext() {
        return testStringFromXmlContext;
    }

    public void setTestStringFromXmlContext(String testStringFromXmlContext) {
        this.testStringFromXmlContext = testStringFromXmlContext;
    }

    User User;


}
