package com.springtest.system.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация чтобы записывать время работы классов
 * Если над классом стоит это аннотация, то в каждый метод будет добавлятья логика связанная с записью времени работы метода
 * По сути прямо на лету генерируется новый класс из которого создается объект, которым я заменю оригинальный объект
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Robot {
}
