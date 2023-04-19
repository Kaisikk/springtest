package com.springtest.system.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация чтобы выводить время работы роботов
 * Может расширяться в будущем, если надо будет добавлять логику в роботов
 */
@Retention(RetentionPolicy.RUNTIME) // указывает, что аннотацию можно будет считывать прямо во время работы программы
public @interface InjectInt {
    // поля которые может принимать аннотация
    int min();
    int max();
}
