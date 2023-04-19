package com.springtest.usecases.usecaseimpl;

import com.springtest.system.annotation.InjectInt;
import com.springtest.usecases.usecase.TestRobotUseCase;

/**
 * Сам бин я создаю и назначаю его поля в context.xml
 */
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

    @Override
    public void sayRobot() {

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
}
