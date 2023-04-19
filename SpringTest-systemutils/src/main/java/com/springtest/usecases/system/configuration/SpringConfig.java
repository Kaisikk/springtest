package com.springtest.usecases.system.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Конфигурационный класс
 * Тут создаются определяются бины и их property
 */
@Configuration
public class SpringConfig {

    /**
     * Создание бина в классе
     * @return String
     */
    @Bean(name= "getString")
    public String getString(){
        return "Hello World";
    }

    /**
     * Создание переменной с аннотацией Lazy
     * С этой аннотацией бин не будет создаваться во время загрузки контекста
     * @param lazy
     * @return
     */
    @Bean
    @Lazy(value = true)
    public String getLazy(String lazy){
        return lazy;
    }

}
