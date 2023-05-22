package com.springtest.usecases.usecaseimpl;

import com.springtest.system.annotation.DeprecatedClass;
import com.springtest.system.annotation.InjectInt;
import com.springtest.system.annotation.PostProxy;
import com.springtest.system.annotation.Robot;
import com.springtest.usecases.usecase.TestRobotUseCase;

import javax.annotation.PostConstruct;

/**
 * Сам бин я создаю и назначаю его поля в context.xml
 */
@Robot
// кастомная deprecated аннотация
@DeprecatedClass(newImpl = TestRobotUseCaseImpl2.class)
public class TestRobotUseCaseImpl implements TestRobotUseCase {

    // количество повторений сообщения
    @InjectInt(min = 2, max = 10)
    private Integer count;

    // сообщение на вывод
    private String message;

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Init метод для класса
     */
    // аннотация чтобы
    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(message);
    }

    public TestRobotUseCaseImpl() {
        System.out.println("Phase 1");
    }

    @PostProxy
    @Override
    public void sayRobot() {

        System.out.println("Phase 3");

        if (count == null)
        count = 5;
        if (message == null) {
            message = "Robot";
        }
        for(int i = 0 ; i < count ; i++){
            if (message == null){
                message = "Robot";
            }
            System.out.println(message);
        }

    }

    /**
     * Тестирование возможности запуска методы после полной настройки бина
     */
    @PostProxy
    @Override
    public void testPostProxy(){
        System.out.println("Аннотация PostProxy успешно отработала после полной настройки бина");
    }
}
