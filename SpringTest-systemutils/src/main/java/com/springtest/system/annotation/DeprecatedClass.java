package com.springtest.system.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация нужна чтобы подменять старую реализацию классов на новую, которую я описал в классе DeprecationHandlerBeanFactoryPostProcessor
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class newImpl();
}
