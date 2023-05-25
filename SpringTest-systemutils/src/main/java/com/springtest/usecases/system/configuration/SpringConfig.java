package com.springtest.usecases.system.configuration;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Конфигурационный класс
 * Тут создаются определяются бины и их property
 */
@Configuration
@ComponentScan(basePackages = "com.springtest.usecases.classconfig.usecaseimpl")
public class SpringConfig {

    /**
     * Создание бина со scope prototype чтобы каждый раз создавался новый бин, когда я к нему обращаюсь
     * Чтобы каждрый раз при обращении к бину он рефрешился, можно сконфигурировать bean так @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
     * @return Color
     */
    @Bean
    @Scope(value = "prototype")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }


}
