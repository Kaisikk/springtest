package com.springtest.usecases.usecaseimpl;

import com.springtest.usecases.usecase.TestRobotUseCase;

/**
 * Класс, который будет создан вместо класса помеченного аннотацией DeprecatedClass
 */
public class TestRobotUseCaseImpl2 extends TestRobotUseCaseImpl implements TestRobotUseCase {

    @Override
    public void sayRobot() {
        System.out.println("Robot №2");
    }
}
